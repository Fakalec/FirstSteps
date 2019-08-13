package out.muravev.pv.presenters

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.MainModelImpl
import out.muravev.pv.utils.DeviceCheckerUtil

class ResultFragmentPresenterImpl(

    private val model: MainModelImpl,
    private val view: MainContract.ResultFragment,
    private val checkDeviceUtil: DeviceCheckerUtil
) :
    MainContract.ResultFragmentPresenter {

    private val resultListener = object : MainContract.DataListener {
        override fun onScreenChanged() {
            view.onResultScreenDraw(model.getSortedList())
        }
    }

    override fun onResultScreenOpened() {
        if (checkDeviceUtil.isDeviceTablet()) {
            model.putResultListener(resultListener)
            model.resultScreenInitialize()
        } else {
            view.onResultScreenDraw(model.getUnsortedList())
        }
    }

    override fun cleanResultPresenterListener() {
        model.clearResultListener()
    }

    override fun onSortButtonClicked() {
        model.sortList()
        view.onResultScreenDraw(model.getSortedList())
    }

    override fun onOriginalButtonClicked() {
        view.onResultScreenDraw(model.getUnsortedList())
    }

    override fun onReverseButtonClicked() {
        model.reverseList()
        view.onResultScreenDraw(model.getSortedList())
    }
}