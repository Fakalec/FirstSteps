package out.muravev.pv.data

class ListMergeSortAlgo {

    // Рекурсивная функция, которая будет принимать лист строк и разделять их.

    fun getMergingBranchedLists(listOfString: List<StringItems>): List<StringItems> {

        if (listOfString.size <= 1) // якорь рекурсии
            return listOfString

        val middleStringIndex = listOfString.size / 2
        val smallerValueList = listOfString.subList(0, middleStringIndex) // создание левого подлиста (меньшие значения)
        val biggerValueList = listOfString.subList(middleStringIndex, listOfString.size) // правый подлист (бОльшие)

        return sortListValues(getMergingBranchedLists(smallerValueList), getMergingBranchedLists(biggerValueList))
    }

    // Функция сортировки принимает подлисты малых и бОльших значений и сортирует их (меньшие в начало, бОльшие в конец)

    private fun sortListValues(
        smallerValueList: List<StringItems>,
        biggerValueList: List<StringItems>
    ): List<StringItems> {

        var leftHandIndex = 0
        var rightHandIndex = 0
        val resultSortedList: MutableList<StringItems> = mutableListOf()

        while (leftHandIndex < smallerValueList.count() && rightHandIndex < biggerValueList.count()) {
            if (smallerValueList[leftHandIndex].name <= biggerValueList[rightHandIndex].name) {
                resultSortedList.add(
                    StringItems(
                        smallerValueList[leftHandIndex].name,
                        smallerValueList[leftHandIndex].creationDate
                    )
                )
                leftHandIndex++
            } else {
                resultSortedList.add(
                    StringItems(
                        biggerValueList[rightHandIndex].name,
                        biggerValueList[rightHandIndex].creationDate
                    )
                )
                rightHandIndex++
            }
        }

        while (leftHandIndex < smallerValueList.size) {
            resultSortedList.add(
                StringItems(
                    smallerValueList[leftHandIndex].name,
                    smallerValueList[leftHandIndex].creationDate
                )
            )
            leftHandIndex++
        }

        while (rightHandIndex < biggerValueList.size) {
            resultSortedList.add(
                StringItems(
                    biggerValueList[rightHandIndex].name,
                    biggerValueList[rightHandIndex].creationDate
                )
            )
            rightHandIndex++
        }

        return resultSortedList
    }
}