package out.muravev.pv.presenters

import out.muravev.pv.contracts.SorterContract

class ResultPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.ResultView
) :
    SorterContract.ResultPresenter {

    override fun onScreenOpened() {
        view.viewResultText(model.getSortedList())
    }

    override fun onOkButtonClicked() {
        model.clearList()
        view.backToSorterActivity()
    }
}