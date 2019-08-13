package out.muravev.pv.models

import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.MainContract

class MainModelImpl(private val listSort: ListSort) {

    private var resultScreenListener: MainContract.DataListener? = null
    private var mainScreenListener: MainContract.DataListener? = null
    private var savedSortedList: ArrayList<String> = arrayListOf()
    private var savedString: String = ""
    private var savedUnsortedList: ArrayList<String> = arrayListOf()

    fun putResultListener(listenerCheck: MainContract.DataListener) {
        resultScreenListener = listenerCheck
    }

    fun putMainListener(listenerCheck: MainContract.DataListener) {
        mainScreenListener = listenerCheck
    }

    fun clearResultListener() {
        resultScreenListener = null
    }

    fun clearMainListener() {
        mainScreenListener = null
    }

    fun hasEnteredText() =
        savedString.isNotEmpty()

    fun setTypedText(text: String) {
        savedString = text
    }

    fun resultScreenInitialize() {
        resultScreenListener?.onScreenChanged()
    }

    fun mainScreenInitialize() {
        mainScreenListener?.onScreenChanged()
    }

    fun addNewItem() {
        savedUnsortedList.add(savedString)
    }

    fun deleteItemOnPosition(itemPosition: Int) {
        savedUnsortedList.removeAt(itemPosition)
    }

    fun clearEnteredText() {
        savedString = ""
    }

    fun changeableListUpdate() {
        savedSortedList = savedUnsortedList
    }

    fun getUnsortedList() =
        savedUnsortedList

    fun getSortedList() =
        savedSortedList

    fun isNotEmptyList() =
        savedUnsortedList.isNotEmpty()

    fun sortList() {
        val sortedList: List<String> = listSort.getMergingBranchedLists(savedUnsortedList)
        savedSortedList = ArrayList(sortedList)
    }

    fun reverseList() {
        val sortedList: List<String> = listSort.getMergingBranchedLists(savedUnsortedList).reversed()
        savedSortedList = ArrayList(sortedList)
    }

    fun clearLists() {
        savedSortedList.clear()
        savedUnsortedList.clear()
    }
}