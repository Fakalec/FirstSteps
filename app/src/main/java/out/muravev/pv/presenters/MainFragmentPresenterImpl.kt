package out.muravev.pv.presenters

import android.annotation.SuppressLint
import android.util.Log
import out.muravev.pv.contracts.MainContract

class MainFragmentPresenterImpl(

    private val model: MainContract.SorterModel,
    private val view: MainContract.SorterView
) :
    MainContract.MainFragmentPresenter {

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

    @SuppressLint("LongLogTag")
    override fun onDeleteButtonClicked(itemPosition: Int) {
        model.deleteItemOnPosition(itemPosition)
//        view.updateList(model.getUnsortedList())
        Log.d("M_MainFragmentPresenterImpl", "${model.getUnsortedList()}")
    }

    override fun onNextButtonClicked() {
        if (model.isNotEmptyList()) {
            view.goToResultScreen()
        } else {
            view.showEmptyListMessage()
        }
    }

    override fun onCleanButtonClicked() {
        model.clearLists()
        view.clearList()
    }

    override fun onTextEdited(text: String) {
        model.setTypedText(text)
    }

    override fun onScreenOpened() {
        view.updateList(model.getUnsortedList())
    }
}