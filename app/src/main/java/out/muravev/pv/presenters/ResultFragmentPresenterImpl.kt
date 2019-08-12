package out.muravev.pv.presenters

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.MainModelImpl
import out.muravev.pv.routers.DeviceChecker

class ResultFragmentPresenterImpl(

    private val model: MainModelImpl,
    private val view: MainContract.ResultFragment,
    private val checkDevice: DeviceChecker
) :
    MainContract.ResultFragmentPresenter {

    private val resultListener = object : MainContract.DataListener {
        override fun onScreenChanged() {
            view.viewResultText(model.getUnsortedListResult())
        }
    }

    override fun onResultScreenOpened() {
        if (checkDevice.isDeviceTablet()) {
            model.putResultListener(resultListener)
            model.resultScreenInitialize()
        } else {
//                view.viewResultText(model.getUnsortedListResult())
        }
    }

    override fun drawKek() = model.getUnsortedList()

    override fun clearResultPresenterListener() {
        model.clearResultListener()
    }

    override fun onBackButtonClicked() {
        if (!checkDevice.isDeviceTablet()) {
            view.backToMainFragment()
        }
    }

    override fun onSortButtonClicked() {
        model.sortList()
        view.viewResultText(model.getSortedListResult())
    }

    override fun onReverseButtonClicked() {
        model.reverseList()
        view.viewResultText(model.getSortedListResult())
    }
}