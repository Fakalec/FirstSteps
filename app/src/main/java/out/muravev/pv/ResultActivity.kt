package out.muravev.pv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.result_activity.*
import out.muravev.pv.presenter.SorterPresenterImpl

class ResultActivity : AppCompatActivity() {

//    lateinit var sortValUse: GlobalSortList
//private var presenter: SorterPresenterImpl? = null
private lateinit var presenter: SorterPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        presenter = application as SorterPresenterImpl
//        sortValUse = application as GlobalSortList
        result_text_view.text = "${presenter.filledList}"
//        sortValUse.listToFill.clear()
        button.setOnClickListener {
            finish()
        }
    }
}
