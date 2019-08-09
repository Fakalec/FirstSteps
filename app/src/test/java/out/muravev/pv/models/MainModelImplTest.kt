package out.muravev.pv.models

/**
 * In this file you can see tests for SorterModel
 * It consists of all model methods
 */

//class MainModelImplTest {
//
//    private var sortAlgorithm: ListSort = ListSort()
//    private var model = MainModelImpl(sortAlgorithm)
//
//    @Test
//    fun `hasEnteredText method when nothing entered in the input line`() {
//        model.savedString = ""
//        val isTextSave = model.hasEnteredText()
//        val expected = false
//        assert(expected == isTextSave) { "empty entered text - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `hasEnteredText method when something entered in the input line`() {
//        model.savedString = "something"
//        val isTextSave = model.hasEnteredText()
//        val expected = true
//        assert(expected == isTextSave) { "entered something - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `setTypedText method when nothing typed in`() {
//        model.setTypedText("")
//        val typedText = model.savedString
//        val expected = ""
//        assert(typedText == expected) { "set nothing typed in variable - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `setTypedText method when something typed in`() {
//        model.setTypedText("something")
//        val typedText = model.savedString
//        val expected = "something"
//        assert(typedText == expected) { "set something typed in variable - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `addNewItem method when no item to add`() {
//        model.savedString = ""
//        model.addNewItem()
//        val emptyStringAdded = model.savedList
//        val expected = listOf("")
//        assert(emptyStringAdded == expected) { "nothing added into list - WRONG RESULT" }
//    }
//
//    @Test
//    fun `addNewItem method when "something" string added`() {
//        model.savedString = "something"
//        model.addNewItem()
//        val somethingStringAdded = model.savedList
//        val expected = listOf("something")
//        assert(somethingStringAdded == expected) { "\"something\" string added into list - WRONG RESULT" }
//    }
//
//    @Test
//    fun `clearEnteredText method`() {
//        model.savedString = "need to clear"
//        model.clearEnteredText()
//        val cleanString = model.savedString
//        val expected = ""
//        assert(cleanString == expected) { "clear text - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `getUnsortedList method`() {
//        model.savedList = arrayListOf("Kotlin", "Java", "Gradle", "Maven")
//        val unsortedList = model.getUnsortedList()
//        val expected = arrayListOf("Kotlin", "Java", "Gradle", "Maven")
//        assert(unsortedList == expected) { "get unsorted list - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `isNotEmptyList method when the list is empty`() {
//        model.savedList = arrayListOf()
//        val emptyListResult = model.isNotEmptyList()
//        val expected = false
//        assert(emptyListResult == expected) { "empty list checking - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `isNotEmptyList method when the list is not empty`() {
//        model.savedList = arrayListOf("peppa", "the", "pig")
//        val emptyListResult = model.isNotEmptyList()
//        val expected = true
//        assert(emptyListResult == expected) { "empty list checking - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `sortList method with unsorted strings`() {
//        model.savedList = arrayListOf("phoenix", "meepo", "kunkka", "naga siren")
//        model.sortList()
//        val sortedList = model.savedList
//        val expected = arrayListOf("kunkka", "meepo", "naga siren", "phoenix")
//        assert(sortedList == expected) { "unsorted strings to sort - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `getSortedListResult method that returns string`() {
//        model.savedList = arrayListOf("apple", "mango", "orange", "strawberry")
//        val returnSortedListToString = model.getSortedListResult()
//        val expected = "[apple, mango, orange, strawberry]"
//        assert(returnSortedListToString == expected) { "return sorted list as string - WRONG RESULT!" }
//    }
//
//    @Test
//    fun `clearList method`() {
//        model.savedList = arrayListOf("mouse", "keyboard")
//        model.clearList()
//        val clearList = model.savedList
//        val expected: ArrayList<String> = arrayListOf()
//        assert(clearList == expected) { "clear list checking - WRONG RESULT!" }
//    }
//}