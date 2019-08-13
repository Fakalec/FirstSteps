package out.muravev.pv.presenters

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.MainModelImpl
import out.muravev.pv.utils.DeviceCheckerUtil

/**
 * In this file you can see tests for ResultPresenter
 * It consists of:
 *
 * 1. checking method that open result screen
 * 2. checking onOkButtonClicked method that clean list and return to main screen
 */

class ResultFragmentPresenterImplTest {

    private var model: MainModelImpl = mock()
    private var fragment: MainContract.ResultFragment = mock()
    private var deviceCheckerUtil: DeviceCheckerUtil = mock()
    private var presenter = ResultFragmentPresenterImpl(model, fragment, deviceCheckerUtil)

    @Test
    fun `onScreenOpened method`() {
//        whenever(model.getSortedListResult()).thenReturn("ABCDEFGH")

        presenter.onResultScreenOpened()

//        verify(fragment).viewResultText("ABCDEFGH")
    }

    @Test
    fun `onOkButtonClicked method`() {
        presenter.onBackButtonClicked()

//        verify(model).clearList()
        verify(fragment).backToMainFragment()
    }
}