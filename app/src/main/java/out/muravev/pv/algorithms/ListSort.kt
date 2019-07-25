package out.muravev.pv.algorithms

import out.muravev.pv.contracts.SorterContract

class ListSort: SorterContract.SortAlgorythm {

    // Рекурсивная функция, которая будет принимать лист строк и разделять их.

    override fun getMergingBranchedLists(listOfString: List<String>): List<String> {

        if (listOfString.size <= 1) // якорь рекурсии
            return listOfString

        val middleStringIndex = listOfString.size / 2
        val smallerValueList = listOfString.subList(0, middleStringIndex) // создание левого подлиста (меньшие значения)
        val biggerValueList = listOfString.subList(middleStringIndex, listOfString.size) // правый подлист (бОльшие)

        return sortListValues(getMergingBranchedLists(smallerValueList), getMergingBranchedLists(biggerValueList))
    }

    // Функция сортировки принимает подлисты малых и бОльших значений и сортирует их (меньшие в начало, бОльшие в конец)

    override fun sortListValues(smallerValueList: List<String>, biggerValueList: List<String>): List<String> {

        var leftHandIndex = 0
        var rightHandIndex = 0
        val resultSortedList: MutableList<String> = mutableListOf()

        while (leftHandIndex < smallerValueList.count() && rightHandIndex < biggerValueList.count()) {
            if (smallerValueList[leftHandIndex] <= biggerValueList[rightHandIndex]) {
                resultSortedList.add(smallerValueList[leftHandIndex])
                leftHandIndex++
            } else {
                resultSortedList.add(biggerValueList[rightHandIndex])
                rightHandIndex++
            }
        }

        while (leftHandIndex < smallerValueList.size) {
            resultSortedList.add(smallerValueList[leftHandIndex])
            leftHandIndex++
        }

        while (rightHandIndex < biggerValueList.size) {
            resultSortedList.add(biggerValueList[rightHandIndex])
            rightHandIndex++
        }

        return resultSortedList
    }
}