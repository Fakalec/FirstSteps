package out.muravev.pv.contracts

import android.content.Context
import androidx.annotation.StringRes

interface MainContract {

    interface SorterView {
        fun updateList(updateList: List<String>)
        fun clearList()
        fun goToResultScreen()
        fun showEmptyListMessage()
        fun showNoTextEnteredMessage()
        fun clearEditText()
    }

    interface MainFragmentPresenter {
        fun onNextButtonClicked()
        fun onAddButtonClicked()
        fun onTextEdited(text: String)
        fun onScreenOpened()// todo
        fun onCleanButtonClicked()
        fun onDeleteButtonClicked(itemPosition: Int)
        }

    interface ResultFragment {
        fun viewResultText(resultText: String)
        fun backToMainFragment()
    }

    interface ResultFragmentPresenter {
        fun onScreenOpened()
        fun onBackButtonClicked()
        fun onSortButtonClicked()
        fun onReverseButtonClicked()
    }
    interface FragmentRouter {
        fun openResultScreen()
        fun openMainScreen()
    }

    interface SorterModel {  // моедль в интерфейсе, если она не необходима, то как использовать ее приватные методы
        fun hasEnteredText(): Boolean
        fun setTypedText(text: String)
        fun addNewItem()
        fun deleteItemOnPosition(itemPosition: Int)
        fun clearEnteredText()
        fun getUnsortedList(): List<String>
        fun isNotEmptyList(): Boolean
        fun sortList()
        fun reverseList()
        fun getSortedListResult(): String
        fun getUnsortedListResult(): String
        fun getClearList(): List<String>
        fun clearLists()
    }

    interface DeviceChecker {
        fun isDeviceTablet(): Boolean
    }

    interface ToastUtils {
        fun errorToast(@StringRes messageResId: Int, context: Context?)
    }
}