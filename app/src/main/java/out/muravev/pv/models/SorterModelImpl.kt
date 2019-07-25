package out.muravev.pv.models

import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.SorterContract

class SorterModelImpl(private val listSort: ListSort) : SorterContract.SorterModel {

    private var savedList: ArrayList<String> = arrayListOf()
    private var savedString: String = ""

    override fun hasEnteredText() = savedString != ""

    override fun setTypedText(text: String) {
        savedString = text
    }

    override fun addNewItem() {
        savedList.add(savedString)
    }

    override fun clearEnteredText() {
        savedString = ""
    }

    override fun getList() = savedList

    override fun isNotEmptyList() = savedList.isNotEmpty()

    override fun sortList() {
        savedList = listSort.getMergingBranchedLists(savedList) as ArrayList<String>
    }

    override fun getSortedList() = savedList.toString()

    override fun clearList() {
        savedList.clear()
    }
}