package out.muravev.pv

import android.view.View

interface SorterContract {

    interface SorterView {
        fun showSortedList()
        fun showAddedEditText()
        fun showEmptyLineToast()
    }

    interface SorterPresenter {
        val filledList : ArrayList<String>
        fun sortList(listToSort: ArrayList<String>)
        fun fillList(inputEditText: String)
//        fun cleanList()
    }

    interface SorterModel {
        val savedText: ArrayList<String>
        fun saveEditText(inputEditText: String): ArrayList<String>
        fun cleanSavedText(): ArrayList<String>
    }
}