package out.muravev.pv.models

import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.MainContract

class MainModelImpl(private val listSort: ListSort) : MainContract.SorterModel {

    private var savedSortedList: ArrayList<String> = arrayListOf()    // need to private? // todo
    private var savedString: String = ""                        // need to private?
    private var savedUnsortedList: ArrayList<String> = arrayListOf()

    override fun hasEnteredText() =
        savedString.isNotEmpty()

    override fun setTypedText(text: String) {
        savedString = text
    }

    override fun addNewItem() {
        savedUnsortedList.add(savedString)
    }

    override fun deleteItemOnPosition(itemPosition: Int) {
        savedUnsortedList.removeAt(itemPosition)
    }

    override fun clearEnteredText() {
        savedString = ""
    }

    override fun getClearList() =
        emptyList<String>()

    override fun getUnsortedList() =
        savedUnsortedList

    override fun isNotEmptyList() =
        savedUnsortedList.isNotEmpty()

    override fun sortList() {
        val sortedList: List<String> = listSort.getMergingBranchedLists(savedUnsortedList)
        savedSortedList = ArrayList(sortedList)
    }

    override fun reverseList() {
        val sortedList: List<String> = listSort.getMergingBranchedLists(savedUnsortedList).reversed()
        savedSortedList = ArrayList(sortedList)
    }

    override fun getSortedListResult() =
        savedSortedList.toString()

    override fun getUnsortedListResult() =
        savedUnsortedList.toString()

    override fun clearLists() {
        savedSortedList.clear()
        savedUnsortedList.clear()
    }
}