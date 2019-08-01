package out.muravev.pv.presenters

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import out.muravev.pv.contracts.SorterContract

/**
 * In this file you can see tests for ResultPresenter
 * It consists of:
 *
 * 1. checking method that open result screen
 * 2. checking onOkButtonClicked method that clean list and return to main screen
 */

class ResultPresenterImplTest {

    private var model: SorterContract.SorterModel = mock()
    private var view: SorterContract.ResultView = mock()
    private var presenter = ResultPresenterImpl(model, view)

    @Test
    fun `check onScreenOpened method`() {
        whenever(model.getSortedListResult()).thenReturn("ABCDEFGH")
        presenter.onScreenOpened()
        verify(view).viewResultText("ABCDEFGH")
    }

    @Test
    fun `check onOkButtonClicked`() {
        presenter.onOkButtonClicked()
        verify(model).clearList()
        verify(view).backToSorterActivity()
    }
}