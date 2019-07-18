package out.muravev.pv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.R.layout.activity_main

var sortedList: List<String> = listOf()
val listToFill = ArrayList<String>()

class SorterActivity : AppCompatActivity() {

    val nullArray: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        stringAdderClicker()
        stringSorterButton()
    }

    private fun stringAdderClicker() {
        add_button.setOnClickListener {
            val inputInEditText: String = this.edit_text.text.toString()
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listToFill) // TODO RecyclerView
            if (inputInEditText == "") {
                showEmptyNotification()
            } else {
                listToFill.add(inputInEditText)
                list_view.adapter = arrayAdapter
                edit_text.setText("")
                Log.d("M_MainActivity", "fill $listToFill")
            }
        }
    }

    private fun stringSorterButton() {
        sort_button.setOnClickListener {
            if (listToFill.isEmpty()) {
                showEmptyNotification()
            } else {
                val resultIntent = Intent(this, ResultActivity::class.java)
                val emptyAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nullArray)
                sortedList = ListSort().getMergingBranchedLists(listToFill)
//                val stringArrayExtra = resultIntent.getStringArrayExtra(sortedList.toString())
                startActivity(resultIntent) // TODO Pass param
                list_view.adapter = emptyAdapter
                edit_text.setText("")
                Log.d("M_SorterActivity", "sort button pressed")
            }
        }
    }

    private fun showEmptyNotification() {
        val emptyLineNotification = Toast.makeText(this, getString(R.string.empty_line_toast), Toast.LENGTH_SHORT) // TODO
        emptyLineNotification.show()
        Log.d("M_MainActivity", "empty line")
    }
}