package out.muravev.pv.data

class ListMergeSortAlgo {

    // Рекурсивная функция, которая будет принимать лист строк и разделять их.

    fun getMergingBranchedLists(listOfTextDate: List<TextDateItems>): List<TextDateItems> {

        if (listOfTextDate.size <= 1) // якорь рекурсии
            return listOfTextDate

        val middleStringIndex = listOfTextDate.size / 2
        val smallerValueList = listOfTextDate.subList(0, middleStringIndex) // создание левого подлиста (меньшие значения)
        val biggerValueList = listOfTextDate.subList(middleStringIndex, listOfTextDate.size) // правый подлист (бОльшие)

        return sortListValues(getMergingBranchedLists(smallerValueList), getMergingBranchedLists(biggerValueList))
    }

    // Функция сортировки принимает подлисты малых и бОльших значений и сортирует их (меньшие в начало, бОльшие в конец)

    private fun sortListValues(
        smallerValueList: List<TextDateItems>,
        biggerValueList: List<TextDateItems>
    ): List<TextDateItems> {

        var leftHandIndex = 0
        var rightHandIndex = 0
        val resultSortedList: MutableList<TextDateItems> = mutableListOf()

        while (leftHandIndex < smallerValueList.count() && rightHandIndex < biggerValueList.count()) {
            if (smallerValueList[leftHandIndex].name <= biggerValueList[rightHandIndex].name) {
                resultSortedList.add(
                    TextDateItems(
                        smallerValueList[leftHandIndex].name,
                        smallerValueList[leftHandIndex].creationDate
                    )
                )
                leftHandIndex++
            } else {
                resultSortedList.add(
                    TextDateItems(
                        biggerValueList[rightHandIndex].name,
                        biggerValueList[rightHandIndex].creationDate
                    )
                )
                rightHandIndex++
            }
        }

        while (leftHandIndex < smallerValueList.size) {
            resultSortedList.add(
                TextDateItems(
                    smallerValueList[leftHandIndex].name,
                    smallerValueList[leftHandIndex].creationDate
                )
            )
            leftHandIndex++
        }

        while (rightHandIndex < biggerValueList.size) {
            resultSortedList.add(
                TextDateItems(
                    biggerValueList[rightHandIndex].name,
                    biggerValueList[rightHandIndex].creationDate
                )
            )
            rightHandIndex++
        }

        return resultSortedList
    }
}