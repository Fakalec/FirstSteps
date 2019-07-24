package out.muravev.pv.presenters

import kotlinx.android.synthetic.main.result_activity.*
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.models.SorterModelImpl
import out.muravev.pv.views.ResultActivity

class ResultPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.ResultView
) :
    SorterContract.ResultPresenter {

    override fun viewSortResult() {
        view.viewResultText(model.setStringList().toString())
    }

    override fun onOkButtonClicked() {
        model.setStringList().clear()
//        view.finish()
    }
}