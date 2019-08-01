package out.muravev.pv.presenters

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import out.muravev.pv.contracts.SorterContract

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

class SorterPresenterImplTest {

    private var model: SorterContract.SorterModel = mock()
    private var view: SorterContract.SorterView = mock()
    private var presenter = SorterPresenterImpl(model, view)

    @Test
    fun `check onAddButtonClicked method when text has entered`() {
        whenever(model.hasEnteredText()).thenReturn(true)
        presenter.onAddButtonClicked()
        verify(view).updateList(listOf())
        verify(model).addNewItem()
        verify(model).clearEnteredText()
        verify(view).clearEditText()
    }

    @Test
    fun `check onAddButtonClicked method when text has not entered`() {
        whenever(model.hasEnteredText()).thenReturn(false)
        presenter.onAddButtonClicked()
        verify(view).showNoTextEnteredMessage()
    }

    @Test
    fun `check onSortButtonClicked method list of items is not empty`() {
        whenever(model.isNotEmptyList()).thenReturn(true)
        presenter.onSortButtonClicked()
        verify(model).sortList()
        verify(view).goToResultScreen()
        verify(view).clearList()
        verify(view).clearEditText()
    }

    @Test
    fun `check onSortButtonClicked method list of items is empty and input line is not empty`() {
        whenever(model.isNotEmptyList()).thenReturn(true)
        whenever(model.hasEnteredText()).thenReturn(true)
        presenter.onSortButtonClicked()
        verify(view).showFilledInputNotification()
    }

    @Test
    fun `check onSortButtonClicked method list of items is empty`() {
        whenever(model.hasEnteredText()).thenReturn(false)
        presenter.onSortButtonClicked()
        verify(view).showEmptyListMessage()
    }

    @Test
    fun `check onTextEdited method when no text edited`() {
        presenter.onTextEdited("")
        verify(model).setTypedText("")
    }

    @Test
    fun `check onTextEdited method when text edited`() {
        presenter.onTextEdited("Hello!")
        verify(model).setTypedText("Hello!")
    }
}