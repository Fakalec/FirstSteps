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
import kotlinx.android.synthetic.main.recycler_view.*
import out.muravev.pv.R
import out.muravev.pv.adapters.RecyclerAdapter
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.ApplicationGlobal
import out.muravev.pv.presenters.MainFragmentPresenterImpl
import out.muravev.pv.routers.FragmentRouterImpl
import out.muravev.pv.toasts.ToastUtilsImpl

class MainFragment : Fragment(), MainContract.SorterView {

    private lateinit var sortPresenter: MainContract.MainFragmentPresenter
    private lateinit var router: MainContract.FragmentRouter
    private val toastUtil = ToastUtilsImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router = FragmentRouterImpl((activity?.application as ApplicationGlobal).deviceChecker, this)
        sortPresenter = MainFragmentPresenterImpl((activity?.application as ApplicationGlobal).listModel, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager = LinearLayoutManager(activity)
        sortPresenter.onScreenOpened()
        initListeners()
    }

    private fun initListeners() {

        add_button.setOnClickListener {
            sortPresenter.onAddButtonClicked()
        }

        next_button.setOnClickListener {
            sortPresenter.onNextButtonClicked()
        }

        clean_button.setOnClickListener {
            sortPresenter.onCleanButtonClicked()
        }

        edit_string.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) =
                sortPresenter.onTextEdited(edit_string.text.toString())

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun adapterChange(updateList: List<String>) {
        recycler.adapter = RecyclerAdapter(updateList)
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
//
//    override fun showFilledInputNotification() {
//        toastChange(R.string.filled_field_toast)
//    }

    override fun updateList(updateList: List<String>) {
        adapterChange(updateList)
    }

    override fun clearEditText() {
        edit_string.setText("")
    }

    override fun clearList() {
        adapterChange(emptyList())
    }
}
