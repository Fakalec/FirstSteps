package out.muravev.pv.contract

interface SorterContract {

    interface SorterView {
        fun showSortedList()
        fun addAndShowEditText()
        fun showEmptyLineToast()
    }

    interface SorterPresenter {
        fun sortList(listToSort: ArrayList<String>): ArrayList<String>
        fun pullString(inputEditText: String)
        fun getList(): ArrayList<String>
        fun cleanList()
    }

    interface SorterModel
}