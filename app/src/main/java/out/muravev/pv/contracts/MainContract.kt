package out.muravev.pv.contracts

import android.content.Context

interface SorterContract {

    interface SorterView {
        fun updateList(updateList: List<String>)
        fun refreshAdapter(emptyList: List<String>)
        fun goToResultScreen()
        fun showEmptyListMessage()
        fun showNoTextEnteredMessage()
        fun updateEditText(emptyString: String)
    }

    interface ResultView {
        fun viewResultText(resultText: String)
        fun backToSorterActivity()
    }

    interface SorterPresenter {
        fun onSortButtonClicked()
        fun onAddButtonClicked()
        fun onTextEdited(text: String)
    }

    interface ResultPresenter {
        fun onScreenOpened()
        fun onOkButtonClicked()
    }

    interface SorterRouter {
        fun openResultScreen()
        fun returnToMainScreen()
    }

    interface SorterModel {
        fun hasEnteredText(): Boolean
        fun setTypedText(text: String)
        fun addNewItem()
        fun clearEnteredText()
        fun getList(): List<String>
        fun isNotEmptyList(): Boolean
        fun sortList()
        fun getSortedList(): String
        fun clearList()
    }

    interface ToastUtils {
        fun errorToast(message: String, context: Context)
    }
}