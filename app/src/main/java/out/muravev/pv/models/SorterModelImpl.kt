package out.muravev.pv.models

import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.SorterContract

class SorterModelImpl(private val listSort: ListSort) : SorterContract.SorterModel {

    var savedList: ArrayList<String> = arrayListOf()    // need to private?
    var savedString: String = ""                        // need to private?

    override fun hasEnteredText() =
        savedString.isNotEmpty()

    override fun setTypedText(text: String) {
        savedString = text
    }

    override fun addNewItem() {
        savedList.add(savedString)
    }

    override fun clearEnteredText() {
        savedString = ""
    }

    override fun getUnsortedList() =
        savedList

    override fun isNotEmptyList() =
        savedList.isNotEmpty()

    override fun sortList() {
        val sortedList: List<String> = listSort.getMergingBranchedLists(savedList)
        savedList = ArrayList(sortedList)
    }

    override fun getSortedListResult() =
        savedList.toString()

    override fun clearList() {
        savedList.clear()
    }
}