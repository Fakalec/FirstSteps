package out.muravev.pv

//import android.content.Intent
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import kotlinx.android.synthetic.main.activity_main.*
//import out.muravev.pv.R.layout.activity_main
//
//import javax.inject.Inject
//
//class SorterActivity : AppCompatActivity() {
//
//    @Inject lateinit var info: Info
//
//    private lateinit var sortValUse: GlobalSortList
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(activity_main)
//        DaggerMagicBox.create().poke(this)
//        hello_text.text = info.text
//        sortValUse = application as GlobalSortList
//        stringAdderButton()
//        stringSorterButton()
//    }
//
//    private fun stringAdderButton() {
//        add_button.setOnClickListener {
//            val inputInEditText: String = this.edit_text.text.toString()
//            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sortValUse.listToFill)
//            if (inputInEditText == "") {
//                showEmptyNotification()
//            } else {
//                sortValUse.listToFill.add(inputInEditText)
//                cycler_recycler.layoutManager = LinearLayoutManager(this)
//                cycler_recycler.adapter = RecyclerAdapter(this, sortValUse.listToFill)
//                list_view.adapter = arrayAdapter
//                edit_text.setText("")
//            }
//        }
//    }
//
//    private fun stringSorterButton() {
//        val nullArray: ArrayList<String> = arrayListOf()
//
//        sort_button.setOnClickListener {
//            if (sortValUse.listToFill.isEmpty()) {
//                showEmptyNotification()
//            } else {
//                val resultIntent = Intent(this, ResultActivity::class.java)
//                val emptyAdapter = RecyclerAdapter(this, nullArray)
//                val emptyAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nullArray)
//                sortValUse.sortedList = ListSort().getMergingBranchedLists(sortValUse.listToFill)
//                startActivity(resultIntent)
//                list_view.adapter = emptyAdapter
//                cycler_recycler.adapter = emptyAdapter
//                edit_text.setText("")
//            }
//        }
//    }
//
//    private fun showEmptyNotification() {
//        val emptyLineNotification = Toast.makeText(this, getString(R.string.empty_line_toast), Toast.LENGTH_SHORT)
//        emptyLineNotification.show()
//    }
//}