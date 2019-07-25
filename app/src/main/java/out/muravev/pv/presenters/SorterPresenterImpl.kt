package out.muravev.pv.presenters

import out.muravev.pv.adapters.RecyclerAdapter
import out.muravev.pv.contracts.SorterContract

class SorterPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.SorterView,
    private val router: SorterContract.SorterRouter
) :
    SorterContract.SorterPresenter {

    override fun onAddButtonClicked() {
        if (model.setTypedText().isNotEmpty()) {
            model.setStringList().add(model.setTypedText())
            view.updateList(RecyclerAdapter(view.returnContext(), model.setStringList())) // ? постоянно вызывается layout manager
        } else {
            view.showEmptyEditToast() //
        }
        view.updateEditText("")
    }

    override fun onSortButtonClicked() {
        if (model.setStringList().isNotEmpty()) {
            model.getSortedList(model.setSortedStringList()) // todo
            router.openResultScreen()
            view.refreshAdapter(RecyclerAdapter(view.returnContext(), emptyList())) // ?
        } else {
            view.showEmptyListToast() //
        }
        view.updateEditText("")
    }

    override fun onTextEdited(text: String) {
        model.getTypedText(text)
    }
}