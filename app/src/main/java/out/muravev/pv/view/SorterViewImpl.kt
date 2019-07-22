package out.muravev.pv.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.*
import out.muravev.pv.presenter.SorterPresenterImpl

class SorterViewImpl : AppCompatActivity(), SorterContract.SorterView {

    private var presenter: SorterPresenterImpl? = null

    override fun showSortedList() {
        val nullArray: ArrayList<String> = arrayListOf()

        sort_button.setOnClickListener {
            if (presenter?.filledList == null) {
                showEmptyLineToast()
            } else {
                val resultIntent = Intent(this, ResultActivity::class.java)
                val emptyAdapter = RecyclerAdapter(this, nullArray)
                presenter?.sortList(presenter!!.filledList)
                startActivity(resultIntent)
//                list_view.adapter = emptyAdapter
                cycler_recycler.adapter = emptyAdapter
                edit_text.setText("")
            }
        }
    }

    override fun showAddedEditText() {
        add_button.setOnClickListener {
            presenter?.fillList(edit_text.text.toString())
            cycler_recycler.layoutManager = LinearLayoutManager(this)
            cycler_recycler.adapter = RecyclerAdapter(this, presenter!!.filledList)
            edit_text.setText("")
        }
    }

    override fun showEmptyLineToast() {
        val emptyLineNotification = Toast.makeText(this, getString(R.string.empty_line_toast), Toast.LENGTH_SHORT)
        emptyLineNotification.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = SorterPresenterImpl(this)
        showAddedEditText()
        showSortedList()
    }


}