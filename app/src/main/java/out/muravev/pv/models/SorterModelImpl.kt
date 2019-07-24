package out.muravev.pv.models

import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.SorterContract

class SorterModelImpl(/*private val listSort: ListSort*/) : SorterContract.SorterModel {

    var savedText: ArrayList<String> = arrayListOf()
    var typedText: String = ""

    override fun setTypedText() = typedText

    override fun getTypedText(text: String) {
        typedText = text
    }

    override fun getSortedList(sortedList: ArrayList<String>) {
        savedText = sortedList
    }

    override fun setStringList() = savedText

    override fun sortedStringList() = ListSort().getMergingBranchedLists(savedText) as ArrayList<String>
}