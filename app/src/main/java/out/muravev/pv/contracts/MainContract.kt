package out.muravev.pv.contracts

interface MainContract {

    interface SorterView {
        fun updateList(updateList: List<String>)
        fun clearList()
        fun goToResultScreen()
        fun showEmptyListMessage()
        fun showNoTextEnteredMessage()
        fun clearEditText()
    }

    interface MainFragmentPresenter : HolderPresenter {
        fun onNextButtonClicked()
        fun onAddButtonClicked()
        fun onTextEdited(text: String)
        fun onMainScreenOpened()
        fun onCleanButtonClicked()
        fun cleanMainPresenterListener()
    }

    interface ResultFragment {
        fun backToMainFragment()
        fun onResultScreenDraw(stringsList: List<String>)
    }

    interface ResultFragmentPresenter {
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
        fun onDeleteButtonClicked(itemPosition: Int)
    }

    interface FragmentRouter {
        fun openResultScreen()
        fun openMainScreen()
    }
}