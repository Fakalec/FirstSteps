package out.muravev.pv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.result_activity.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        result_text_view.text = "$sortedList"
        listToFill.clear()
        button.setOnClickListener {
            finish()
            Log.d("M_ResultActivity", "going back to main window")
        }
    }
}
