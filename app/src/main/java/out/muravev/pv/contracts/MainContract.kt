package out.muravev.pv.contracts

import android.content.Context

interface SorterContract {

    interface SortAlgorithm {
        fun getMergingBranchedLists(listOfString: List<String>): List<String>
        fun sortListValues(smallerValueList: List<String>, biggerValueList: List<String>): List<String>
    }

    interface SorterView {
        fun updateList(updateList: List<String>)
        fun showToast(message: String)
        fun updateEditText(updateString: String)
        fun refreshAdapter(emptyList: List<String>)
        fun returnContext(): Context
        fun goToResultScreen()
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
        fun getTypedText(text: String)
        fun setStringList(): ArrayList<String>
        fun getSortedList(sortedList: ArrayList<String>)
        fun setSortedStringList(): ArrayList<String>
        fun setEmptyTextToEdit(): String
        fun setTypedText(): String
    }

    interface ToastUtils {
        fun errorToast(message: String, context: Context)
    }
}