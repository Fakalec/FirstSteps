package out.muravev.pv

import org.junit.Test
import out.muravev.pv.presenter.ListSort

/**
 * In this file you can see Unit tests for ListSorter
 * It consists of:
 *
 * 1. null input string
 * 2. check odd string number in list
 * 3. check even string number in list
 * 4. check non-letter characters
 */

class UnitTestForListSorter {
    @Test
    fun `checkNullString - checking for just one null string in list`() {
        val nullableList = mutableListOf("")
        val sortedList = ListSort().getMergingBranchedLists(nullableList)
        println(sortedList)

        val expected = mutableListOf("")
        assert(expected == sortedList) { "null string in list - WRONG RESULT" }
    }

    @Test
    fun `checkOdd - checking for odd string number in list`() {
        val oddNumberOfString = mutableListOf("Kotlin", "Java", "C#")
        val sortedList = ListSort().getMergingBranchedLists(oddNumberOfString)
        println(sortedList)

        val expected = mutableListOf("C#", "Java", "Kotlin")
        assert(expected == sortedList) { "odd number of strings - WRONG RESULT!!!" }
    }

    @Test
    fun `checkEven - checking for even string number in list`() {
        val evenNumberOfString = mutableListOf("Python", "Assembly", "Swift", "ANSI C")

        /*
         * В ASCII таблице буквенные символы верхнего регистра имеют значения ниже, чем у букв нижнего регистра.
         * Исходя из этого сортировка строк "Assembly" и "ANSI C" происходит в порядке: "ANSI C", "Assembly".
        */

        val sortedList = ListSort().getMergingBranchedLists(evenNumberOfString)
        println(sortedList)

        val expected = mutableListOf("ANSI C", "Assembly", "Python", "Swift")
        assert(expected == sortedList) { "even number of strings - WRONG RESULT!!!" }
    }

    @Test
    fun `checkNonLetterString - checking for non-letter character strings in  list`() {
        val nonLetterList = mutableListOf("))(*&", "^&$#", "456", "@!#$", " ", "")
        val sortedList = ListSort().getMergingBranchedLists(nonLetterList)
        println(sortedList)

        val expected = mutableListOf("", " ", "))(*&", "456", "@!#$", "^&$#")
        assert(expected == sortedList) { "non-letter characters - WRONG RESULT!!!" }
    }
}
