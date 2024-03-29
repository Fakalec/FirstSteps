package out.muravev.pv.presenters

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.data.TextItemModel
import out.muravev.pv.utils.DeviceCheckerUtil

class ResultPresenterImpl(

    private val model: TextItemModel,
    private val view: MainContract.ResultFragment,
    private val checkDeviceUtil: DeviceCheckerUtil
) :
    MainContract.ResultPresenter {

    private val resultListener = object : MainContract.ScreenChangeListener {
        override fun onScreenChanged() {
            view.onResultScreenDraw(model.getUnsortedList())
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
        view.onResultScreenDraw(model.getSortedList())

    }

    override fun onOriginalButtonClicked() {
        view.onResultScreenDraw(model.getUnsortedList())

    }

    override fun onReverseButtonClicked() {
        view.onResultScreenDraw(model.getReverseSortedList())

    }
}