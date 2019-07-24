package out.muravev.pv.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.R
import out.muravev.pv.Routers.SorterRouterImpl
//import out.muravev.pv.Routers.SorterRouterImpl
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.models.ApplicationGlobalModel
import out.muravev.pv.adapters.RecyclerAdapter
import out.muravev.pv.presenters.SorterPresenterImpl

class SorterActivity : AppCompatActivity(), SorterContract.SorterView {

    private lateinit var sortPresenter: SorterPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sortPresenter = SorterPresenterImpl((application as ApplicationGlobalModel).listModel, this, SorterRouterImpl(this))

        initListeners()
    }

    private fun initListeners() {
        add_button.setOnClickListener { sortPresenter.onAddButtonClicked() }

        sort_button.setOnClickListener { sortPresenter.onSortButtonClicked()
//            val resultIntent = Intent(this, ResultActivity::class.java)
//            startActivity(resultIntent)
        }


        edit_string.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) =
                sortPresenter.onTextEdited(edit_string.text.toString())

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    override fun showEmptyListToast() {
        val emptyListNotification = Toast.makeText(this, getString(R.string.empty_list_toast), Toast.LENGTH_SHORT) // todo
        emptyListNotification.show()
    }

    override fun showEmptyEditToast() {
        val emptyLineNotification = Toast.makeText(this, getString(R.string.empty_edit_toast), Toast.LENGTH_SHORT)
        emptyLineNotification.show()
    }

    override fun updateList(list: ArrayList<String>) {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerAdapter(this, list)
    }

    override fun updateEditText(updateString: String) {
        edit_string.text = Editable.Factory.getInstance().newEditable(updateString)
    }

    override fun refreshAdapter(adapter: RecyclerAdapter) {
        recycler.adapter = adapter
    }

    override fun returnContext() = this

    override fun returnIntent(intent: Intent) {
//        startActivity(intent)
    }
}
