package out.muravev.pv.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.R
import out.muravev.pv.contract.SorterContract
import out.muravev.pv.model.GlobalModel
import out.muravev.pv.presenter.RecyclerAdapter
import out.muravev.pv.presenter.SorterPresenterImpl

class SorterViewImpl : AppCompatActivity(), SorterContract.SorterView {

    private lateinit var sortPresenter: SorterPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sortPresenter = SorterPresenterImpl((application as GlobalModel).listModel)
        addAndShowEditText()
        showSortedList()
    }

    override fun addAndShowEditText() {
        add_button.setOnClickListener {
            if (edit_text.text.toString() == "") {
                showEmptyLineToast()
            } else {
                sortPresenter.pullString(edit_text.text.toString())
                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = RecyclerAdapter(this, sortPresenter.getList())
                edit_text.setText("")
            }
        }
    }

    override fun showSortedList() {
        val nullArray: ArrayList<String> = arrayListOf()

        sort_button.setOnClickListener {
            if (sortPresenter.getList() == nullArray) {
                showEmptyLineToast()
            } else {
                val resultIntent = Intent(this, ResultActivity::class.java)
                sortPresenter.sortList(sortPresenter.getList())
                startActivity(resultIntent)
                recycler.adapter = RecyclerAdapter(this, nullArray)
                edit_text.setText("")
            }
        }
    }

    override fun showEmptyLineToast() {
        val emptyLineNotification = Toast.makeText(this, getString(R.string.empty_line_toast), Toast.LENGTH_SHORT)
        emptyLineNotification.show()
    }
}