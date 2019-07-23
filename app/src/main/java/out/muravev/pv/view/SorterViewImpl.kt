package out.muravev.pv.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.*
import out.muravev.pv.contract.SorterContract
import out.muravev.pv.presenter.SorterPresenterImpl

class SorterViewImpl : AppCompatActivity(), SorterContract.SorterView {

    private lateinit var presenter: SorterPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = SorterPresenterImpl((application as GlobalModel).model)
        addAndShowEditText()
        showSortedList()
    }

    override fun addAndShowEditText() {
        add_button.setOnClickListener {
            if (edit_text.text.toString() == "") {
                showEmptyLineToast()
            } else {
                presenter.pullString(edit_text.text.toString())
                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = RecyclerAdapter(this, presenter.getList())
                edit_text.setText("")
            }
        }
    }

    override fun showSortedList() {
        val nullArray: ArrayList<String> = arrayListOf()

        sort_button.setOnClickListener {
            if (presenter.getList() == nullArray) {
                showEmptyLineToast()
            } else {
                val resultIntent = Intent(this, ResultActivity::class.java)
                presenter.sortList(presenter.getList())
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