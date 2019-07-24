package out.muravev.pv.contracts

import android.content.Context
import android.content.Intent
import android.widget.Adapter
import out.muravev.pv.adapters.RecyclerAdapter

interface SorterContract {

    interface SorterView {
        fun updateList(list: ArrayList<String>)
        fun showEmptyEditToast()
        fun showEmptyListToast()
        fun updateEditText(updateString: String)
        fun refreshAdapter(adapter: RecyclerAdapter)
        fun returnIntent(intent: Intent)
        fun returnContext(): Context
    }

    interface ResultView {
        fun viewResultText(resultText: String)
    }

    interface SorterPresenter { // todo translate to russian language
        fun onSortButtonClicked()
        fun onAddButtonClicked()
        fun onTextEdited(text: String)
    }

    interface ResultPresenter {
        fun viewSortResult()
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
        fun sortedStringList(): ArrayList<String> // ?
    }
}