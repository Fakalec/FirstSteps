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
        fun clearMainPresenterListener()
    }

    interface ResultFragment {
        fun viewResultText(resultText: String)
        fun backToMainFragment()
    }

    interface ResultFragmentPresenter {
        fun onResultScreenOpened()
        fun onBackButtonClicked()
        fun onSortButtonClicked()
        fun onReverseButtonClicked()
        fun clearResultPresenterListener()
        fun drawKek() : ArrayList<String>
    }

    interface DataListener {
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