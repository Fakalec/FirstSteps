package out.muravev.pv.presenters

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.MainModelImpl
import out.muravev.pv.routers.DeviceChecker

class MainFragmentPresenterImpl(

    private val model: MainModelImpl,
    private val view: MainContract.SorterView,
    private val checkDevice: DeviceChecker
) :
    MainContract.MainFragmentPresenter, MainContract.HolderPresenter {

    private var mainListener = object : MainContract.DataListener {
        override fun onScreenChanged() {
            view.updateList(model.getUnsortedList())
        }
    }

    override fun clearMainPresenterListener() {
        model.clearMainListener()
    }

    override fun onAddButtonClicked() {
        if (model.hasEnteredText()) {
            model.addNewItem()
            model.clearEnteredText()
            view.updateList(model.getUnsortedList())
            view.clearEditText()
            model.resultScreenInitialize()
        } else {
            view.showNoTextEnteredMessage()
        }
    }

    override fun onDeleteButtonClicked(itemPosition: Int) {
        model.deleteItemOnPosition(itemPosition)
        view.updateList(model.getUnsortedList())
    }

    override fun onNextButtonClicked() {
        if (model.isNotEmptyList()) {
            if (!checkDevice.isDeviceTablet()) {
//                model.resultScreenInitialize()
//            } else {
                view.goToResultScreen()
            }
        } else {
            view.showEmptyListMessage()
        }
    }

    override fun onCleanButtonClicked() {
        model.clearLists()
        view.clearList()
    }

    override fun onTextEdited(text: String) {
        model.setTypedText(text)
    }

    override fun onMainScreenOpened() {
        if (checkDevice.isDeviceTablet()) {
            model.putMainListener(mainListener)                 // it doesn't work
            model.mainScreenInitialize()
        } else {
            view.updateList(model.getUnsortedList())
        }
    }
}