package out.muravev.pv.presenters

import out.muravev.pv.contracts.SorterContract

class SorterPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.SorterView
) :
    SorterContract.SorterPresenter {

    override fun onAddButtonClicked() {
        if (model.hasEnteredText()) {
            model.addNewItem()
            model.clearEnteredText()
            view.updateList(model.getList())
        } else {
            view.showNoTextEnteredMessage()
        }
        view.updateEditText("")
    }

    override fun onSortButtonClicked() {
        if (model.isNotEmptyList()) {
            model.sortList()
            view.goToResultScreen()
            view.refreshAdapter(emptyList())
            view.updateEditText("")
        } else {
            view.showEmptyListMessage()
        }
    }

    override fun onTextEdited(text: String) {
        model.setTypedText(text)
    }
}