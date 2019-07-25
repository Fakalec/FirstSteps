package out.muravev.pv.contracts

import android.content.Context
import out.muravev.pv.adapters.RecyclerAdapter

interface SorterContract {

    interface SortAlgorythm {
        fun getMergingBranchedLists(listOfString: List<String>): List<String>
        fun sortListValues(smallerValueList: List<String>, biggerValueList: List<String>): List<String>
    }

    interface SorterView {
        fun updateList(adapter: RecyclerAdapter)
        fun showEmptyEditToast()
        fun showEmptyListToast()
        fun updateEditText(updateString: String)
        fun refreshAdapter(adapter: RecyclerAdapter)
        fun returnContext(): Context
    }

    interface ResultView {
        fun viewResultText(resultText: String)
        fun backToSorterActivity()
    }

    interface SorterPresenter { // todo translate to russian language
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
    }

    interface SorterModel {
        fun setTypedText(): String
        fun getTypedText(text: String)
        fun setStringList(): ArrayList<String> // ?
        fun getSortedList(sortedList: ArrayList<String>)
        fun setSortedStringList(): ArrayList<String> // ?
    }
}