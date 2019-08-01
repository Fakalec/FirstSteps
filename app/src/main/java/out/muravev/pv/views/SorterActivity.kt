package out.muravev.pv.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.R
import out.muravev.pv.adapters.RecyclerAdapter
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.models.ApplicationGlobalModel
import out.muravev.pv.presenters.SorterPresenterImpl
import out.muravev.pv.routers.SorterRouterImpl
import out.muravev.pv.toasts.ToastUtilsImpl

class SorterActivity : AppCompatActivity(), SorterContract.SorterView {

    private lateinit var sortPresenter: SorterPresenterImpl
    private lateinit var router: SorterRouterImpl
    private lateinit var toastUtil: ToastUtilsImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = SorterRouterImpl(this)
        toastUtil = ToastUtilsImpl()
        sortPresenter =
            SorterPresenterImpl((application as ApplicationGlobalModel).listModel, this)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerAdapter(this, listOf())
        initListeners()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        sortPresenter.screenRotationUpdate()
    }

    private fun initListeners() {
        add_button.setOnClickListener { sortPresenter.onAddButtonClicked() }

        sort_button.setOnClickListener {
            sortPresenter.onSortButtonClicked()
        }

        edit_string.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) =
                sortPresenter.onTextEdited(edit_string.text.toString())

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    override fun updateRecyclerWhenRotate(updateList: List<String>) {
        recycler.adapter = RecyclerAdapter(this, updateList)
    }

    override fun goToResultScreen() {
        router.openResultScreen()
    }

    override fun showEmptyListMessage() {
        toastUtil.errorToast(R.string.empty_list_toast, this)
    }

    override fun showNoTextEnteredMessage() {
        toastUtil.errorToast(R.string.empty_edit_toast, this)
    }

    override fun showFilledInputNotification() {
        toastUtil.errorToast(R.string.filled_field_toast, this)
    }

    override fun updateList(updateList: List<String>) {
        recycler.adapter = RecyclerAdapter(this, updateList)
    }

    override fun clearEditText() {
        edit_string.setText("")
    }

    override fun clearList() {
        recycler.adapter = RecyclerAdapter(this, emptyList())
    }
}
