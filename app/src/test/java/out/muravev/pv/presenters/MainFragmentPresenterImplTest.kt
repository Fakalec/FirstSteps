package out.muravev.pv.presenters

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.StringsModel
import out.muravev.pv.utils.DeviceCheckerUtil

/**
 * In this file you can see tests for SorterPresenter
 * It consists of:
 *
 * 1. checking onAddButtonClicked method with text entered
 * 2. checking onAddButtonClicked method with no text entered
 * 3. checking onSortButtonClicked method with not empty list
 * 4. checking onSortButtonClicked method with empty list and not empty input line
 * 5. checking onSortButtonClicked method with empty list
 * 6. checking onTextEdited method with no text edited
 * 7. checking onTextEdited method with something text edited
 */

class MainFragmentPresenterImplTest {

    private var model: StringsModel = mock()
    private var view: MainContract.SorterView = mock()
    private var deviceCheckerUtil: DeviceCheckerUtil = mock()
    private var presenter = MainFragmentPresenterImpl(model, view, deviceCheckerUtil)

    @Test
    fun `onAddButtonClicked method when text has entered`() {
        whenever(model.hasEnteredText()).thenReturn(true)

        presenter.onAddButtonClicked()

        verify(view).updateList(listOf())
        verify(model).addNewItem()
        verify(model).clearEnteredText()
        verify(view).clearEditText()
    }

    @Test
    fun `onAddButtonClicked method when text has not entered`() {
        whenever(model.hasEnteredText()).thenReturn(false)

        presenter.onAddButtonClicked()

        verify(view).showNoTextEnteredMessage()
    }

    @Test
    fun `onSortButtonClicked method list of items is not empty`() {
        whenever(model.isNotEmptyList()).thenReturn(true)

        presenter.onNextButtonClicked()

        verify(model).sortList()
        verify(view).goToResultScreen()
        verify(view).clearList()
        verify(view).clearEditText()
    }

//    @Test
//    fun `onSortButtonClicked method list of items is empty and input line is not empty`() {
//        whenever(model.isNotEmptyList()).thenReturn(true)
//        whenever(model.hasEnteredText()).thenReturn(true)
//
//        presenter.onNextButtonClicked()
//
//        verify(view).showFilledInputNotification()
//    }

    @Test
    fun `onSortButtonClicked method list of items is empty`() {
        whenever(model.hasEnteredText()).thenReturn(false)

        presenter.onNextButtonClicked()

        verify(view).showEmptyListMessage()
    }

    @Test
    fun `onTextEdited method when no text edited`() {
        presenter.onTextEdited("")

        verify(model).setTypedText("")
    }

    @Test
    fun `onTextEdited method when text edited`() {
        presenter.onTextEdited("Hello!")

        verify(model).setTypedText("Hello!")
    }
}