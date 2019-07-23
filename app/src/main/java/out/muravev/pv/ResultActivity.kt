package out.muravev.pv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.result_activity.*
import out.muravev.pv.presenter.SorterPresenterImpl

class ResultActivity : AppCompatActivity() {

    private lateinit var presenter: SorterPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        presenter = SorterPresenterImpl((application as GlobalModel).model)
        result_text_view.text = "${presenter.getList()}"
        button.setOnClickListener {
            presenter.cleanList()
            finish()
        }
    }
}
