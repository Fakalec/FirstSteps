package out.muravev.pv.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.result_activity.*
import out.muravev.pv.R
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.models.ApplicationGlobalModel
import out.muravev.pv.presenters.ResultPresenterImpl

class ResultActivity : AppCompatActivity(), SorterContract.ResultView {

    private lateinit var resultPresenter: ResultPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        resultPresenter = ResultPresenterImpl((application as ApplicationGlobalModel).listModel, this)

        resultPresenter.viewSortResult() // onScreenOpened
        button.setOnClickListener { resultPresenter.onOkButtonClicked()
            finish()
        }
    }

    override fun viewResultText(resultText: String) {
        result_text_view.text = resultText
    }
}
