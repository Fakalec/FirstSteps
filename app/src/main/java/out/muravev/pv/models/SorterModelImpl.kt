package out.muravev.pv.models

import out.muravev.pv.contracts.SorterContract

class SorterModelImpl(private val listSort: SorterContract.SortAlgorythm) : SorterContract.SorterModel { // как запихать лист в параметр чтобы потом не было проблем с ини

    private var savedText: ArrayList<String> = arrayListOf()
    private var typedText: String = ""

    override fun getTypedText(text: String) {
        typedText = text
    }

    override fun getSortedList(sortedList: ArrayList<String>) {
        savedText = sortedList
    }

    override fun setTypedText() = typedText

    override fun setStringList() = savedText

    override fun setSortedStringList() = listSort.getMergingBranchedLists(savedText) as ArrayList<String>/*ListSort().getMergingBranchedLists(savedText) as ArrayList<String>*/
}