package out.muravev.pv.presenters

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.contracts.ResultContract

/**
 * In this file you can see tests for ResultPresenter
 * It consists of:
 *
 * 1. checking method that open result screen
 * 2. checking onOkButtonClicked method that clean list and return to main screen
 */

class ResultFragmentPresenterImplTest {

    private var model: MainContract.SorterModel = mock()
    private var fragment: ResultContract.ResultFragment = mock()
    private var presenter = ResultFragmentPresenterImpl(model, fragment)

    @Test
    fun `onScreenOpened method`() {
        whenever(model.getSortedListResult()).thenReturn("ABCDEFGH")

        presenter.onScreenOpened()

        verify(fragment).viewResultText("ABCDEFGH")
    }

    @Test
    fun `onOkButtonClicked method`() {
        presenter.onOkButtonClicked()

        verify(model).clearList()
        verify(fragment).backToMainFragment()
    }
}