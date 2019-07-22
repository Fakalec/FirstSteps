package out.muravev.pv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.result_activity.*

class ResultActivity : AppCompatActivity() {

    lateinit var sortValUse: GlobalSortList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        sortValUse = application as GlobalSortList
        result_text_view.text = "${sortValUse.sortedList}"
        sortValUse.listToFill.clear()
        button.setOnClickListener {
            finish()
        }
    }
}
