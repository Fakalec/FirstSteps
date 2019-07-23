package out.muravev.pv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.result_activity.*
import out.muravev.pv.R
import out.muravev.pv.model.GlobalModel
import out.muravev.pv.presenter.SorterPresenterImpl

class ResultActivity : AppCompatActivity() {

    private lateinit var sortPresenter: SorterPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        sortPresenter = SorterPresenterImpl((application as GlobalModel).listModel)
        result_text_view.text = "${sortPresenter.getList()}"
        button.setOnClickListener {
            sortPresenter.cleanList()
            finish()
        }
    }
}
