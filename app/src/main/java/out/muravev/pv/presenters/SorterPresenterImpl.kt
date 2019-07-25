package out.muravev.pv.presenters

import out.muravev.pv.R
import out.muravev.pv.contracts.SorterContract

class SorterPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.SorterView
) :
    SorterContract.SorterPresenter {

    override fun onAddButtonClicked() {
        if (model.setTypedText().isNotEmpty()) {
            model.setStringList().add(model.setTypedText())
            view.updateList(model.setStringList())
        } else {
            view.showToast(view.returnContext().getString(R.string.empty_edit_toast))
        }
        view.updateEditText(model.setEmptyTextToEdit())
    }

    override fun onSortButtonClicked() {
        if (model.setStringList().isNotEmpty()) {
            model.getSortedList(model.setSortedStringList())
            view.goToResultScreen()
            view.refreshAdapter(emptyList())
        } else {
            view.showToast(view.returnContext().getString(R.string.empty_list_toast))
        }
        view.updateEditText(model.setEmptyTextToEdit())
    }

    override fun onTextEdited(text: String) {
        model.getTypedText(text)
    }
}