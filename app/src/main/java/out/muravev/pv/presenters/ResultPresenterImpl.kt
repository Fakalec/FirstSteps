package out.muravev.pv.presenters

import out.muravev.pv.contracts.SorterContract

class ResultPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.ResultView
) :
    SorterContract.ResultPresenter {

    override fun onScreenOpened() {
        view.viewResultText(model.setStringList().toString())
    }

    override fun onOkButtonClicked() {
        model.setStringList().clear()
        view.backToSorterActivity()
    }
}