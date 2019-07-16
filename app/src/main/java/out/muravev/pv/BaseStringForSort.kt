package out.muravev.pv

class BaseStringForSort(private val stringName: String) {
    fun stringadder() : MutableList<String> {
        val lstOfStrings = mutableListOf<String>()
        lstOfStrings.add(stringName)
        return lstOfStrings
    }
}

//class StringSorter(val inputList: List<String>) {
//    fun sortHardWithMerge(leftList: MutableList<String>, rightList: MutableList<String>) {
//
//        var lastIndOfLeft = middleElement - firstElement + 1
//        var firstIndOfRight = lastElement - middleElement
//
//        val leftStr: MutableList<String>
//        val rightStr: MutableList<String>
//
//    }
//}

fun merge(leftList: List<Int>, rightList: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    var newList : MutableList<Int> = mutableListOf()

    while (indexLeft < leftList.count() && indexRight < rightList.count()) {
        if (leftList[indexLeft] <= rightList[indexRight]) {
            newList.add(leftList[indexLeft])
            indexLeft++
        } else {
            newList.add(rightList[indexRight])
            indexRight++
        }
    }
    while (indexLeft < leftList.size) {
        newList.add(leftList[indexLeft])
        indexLeft++
    }
    while (indexRight < rightList.size) {
        newList.add(rightList[indexRight])
        indexRight++
    }
    return newList;
}

fun main() {
    val testy = BaseStringForSort("")
    println(testy.stringadder())
}