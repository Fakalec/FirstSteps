package out.muravev.pv.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import out.muravev.pv.R
import out.muravev.pv.adapters.StringsRecyclerAdapter
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.data.ApplicationGlobal
import out.muravev.pv.data.TextDateItems
import out.muravev.pv.presenters.MainFragmentPresenterImpl
import out.muravev.pv.routers.FragmentRouterImpl
import out.muravev.pv.utils.ToastUtils

class MainFragment : Fragment(), MainContract.MainFragment {

    private lateinit var mainPresenter: MainContract.MainFragmentPresenter
    private lateinit var router: MainContract.FragmentRouter
    private val toastUtil = ToastUtils()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        router = FragmentRouterImpl(this)
        mainPresenter = MainFragmentPresenterImpl(
            (activity?.application as ApplicationGlobal).textItemModel,
            this,
            (activity?.application as ApplicationGlobal).deviceChecker
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager = LinearLayoutManager(activity)
        mainPresenter.onMainScreenOpened()
        initListeners()
    }

    override fun onDetach() {
        super.onDetach()
        mainPresenter.cleanMainPresenterListener()
    }

    private fun initListeners() {

        add_button.setOnClickListener {
            mainPresenter.onAddButtonClicked()
        }

        if (next_button != null) {
            @Suppress("PLUGIN_WARNING")
            next_button.setOnClickListener {
                mainPresenter.onNextButtonClicked()
            }
        }

        clean_button.setOnClickListener {
            mainPresenter.onCleanButtonClicked()
        }

        edit_string.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) =
                mainPresenter.onTextEdited(edit_string.text.toString())

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun adapterChange(updateList: List<TextDateItems>) {
        recycler.adapter = StringsRecyclerAdapter(updateList, mainPresenter)
    }

    private fun toastChange(toastTextId: Int) {
        toastUtil.errorToast(toastTextId, activity?.application)
    }

    override fun goToResultScreen() {
        router.openResultScreen()
    }

    override fun showEmptyListMessage() {
        toastChange(R.string.empty_list_toast)
    }

    override fun showNoTextEnteredMessage() {
        toastChange(R.string.empty_edit_toast)
    }

    override fun updateList(updateList: List<TextDateItems>) {
        adapterChange(updateList)
    }

    override fun clearList() {
        adapterChange(emptyList())
    }

    override fun clearEditText() {
        edit_string.setText("")
    }
}
