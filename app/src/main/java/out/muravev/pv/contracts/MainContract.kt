package out.muravev.pv.contracts

import android.content.Context
import androidx.annotation.StringRes

interface SorterContract {

    interface SorterView {
        fun updateList(updateList: List<String>)
        fun clearList()
        fun goToResultScreen()
        fun showEmptyListMessage()
        fun showNoTextEnteredMessage()
        fun showFilledInputNotification()
        fun clearEditText()
        fun updateRecyclerWhenRotate(updateList: List<String>)
    }

    interface ResultView {
        fun viewResultText(resultText: String)
        fun backToSorterActivity()
    }

    interface SorterPresenter {
        fun onSortButtonClicked()
        fun onAddButtonClicked()
        fun onTextEdited(text: String)
        fun screenRotationUpdate()
    }

    interface ResultPresenter {
        fun onScreenOpened()
        fun onOkButtonClicked()
    }

    interface SorterRouter {
        fun openResultScreen()
        fun returnToMainScreen()
    }

    interface SorterModel {
        fun hasEnteredText(): Boolean
        fun setTypedText(text: String)
        fun addNewItem()
        fun clearEnteredText()
        fun getUnsortedList(): List<String>
        fun isNotEmptyList(): Boolean
        fun sortList()
        fun getSortedListResult(): String
        fun clearList()
    }

    interface ToastUtils {
        fun errorToast(@StringRes messageResId: Int, context: Context)
    }
}