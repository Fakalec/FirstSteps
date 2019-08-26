package out.muravev.pv.presenters

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.data.TextItemModel
import out.muravev.pv.utils.DeviceCheckerUtil

class MainFragmentPresenterImpl(

    private val model: TextItemModel,
    private val view: MainContract.SorterView,
    private val checkDeviceUtil: DeviceCheckerUtil
) :
    MainContract.MainFragmentPresenter, MainContract.HolderPresenter {

    private var mainListener = object : MainContract.ScreenChangeListener {
        override fun onScreenChanged() {
            view.updateList(model.getUnsortedList())
        }
    }

    override fun cleanMainPresenterListener() {
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
        model.resultScreenInitialize()
    }

    override fun onNextButtonClicked() {
        if (model.isNotEmptyList()) {
            view.goToResultScreen()
        } else {
            view.showEmptyListMessage()
        }
    }

    override fun onCleanButtonClicked() {
        model.clearLists()
        view.clearList()
        model.resultScreenInitialize()
    }

    override fun onTextEdited(text: String) {
        model.setTypedText(text)
    }

    override fun onMainScreenOpened() {
        if (checkDeviceUtil.isDeviceTablet()) {
            model.putMainListener(mainListener)
            model.mainScreenInitialize()
        } else {
            view.updateList(model.getUnsortedList())
        }
    }
}