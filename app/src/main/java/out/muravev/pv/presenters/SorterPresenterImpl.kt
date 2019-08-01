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
            view.updateList(model.getUnsortedList())
            view.clearEditText()
        } else {
            view.showNoTextEnteredMessage()
        }
    }

    override fun onSortButtonClicked() {
        if (model.isNotEmptyList() && !model.hasEnteredText()) {
            model.sortList()
            view.goToResultScreen()
            view.clearList()
            view.clearEditText()
        } else if (model.hasEnteredText()) {
            view.showFilledInputNotification()
        } else {
            view.showEmptyListMessage()
        }
    }

    override fun onTextEdited(text: String) {
        model.setTypedText(text)
    }

    override fun screenRotationUpdate() {
        view.updateList(model.getUnsortedList())
    }
}