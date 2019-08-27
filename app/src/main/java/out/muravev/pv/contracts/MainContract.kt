package out.muravev.pv.contracts

import out.muravev.pv.data.TextDateItems

interface MainContract {

    interface MainFragment {
        fun updateList(updateList: List<TextDateItems>)
        fun clearList()
        fun goToResultScreen()
        fun showEmptyListMessage()
        fun showNoTextEnteredMessage()
        fun clearEditText()
    }

    interface MainPresenter : HolderPresenter {
        fun onNextButtonClicked()
        fun onAddButtonClicked()
        fun onTextEdited(text: String)
        fun onMainScreenOpened()
        fun onCleanButtonClicked()
        fun cleanMainPresenterListener()
    }

    interface ResultFragment {
        fun backToMainFragment()
        fun onResultScreenDraw(stringsList: List<TextDateItems>)
    }

    interface ResultPresenter {
        fun onResultScreenOpened()
        fun onSortButtonClicked()
        fun onReverseButtonClicked()
        fun onOriginalButtonClicked()
        fun cleanResultPresenterListener()
    }

    interface ScreenChangeListener {
        fun onScreenChanged()
    }

    interface HolderPresenter {
        fun onDeleteButtonClicked(idKey: Int)
    }

    interface FragmentRouter {
        fun openResultScreen()
        fun openMainScreen()
    }
}