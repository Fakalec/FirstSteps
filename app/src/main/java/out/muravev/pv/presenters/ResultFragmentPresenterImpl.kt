package out.muravev.pv.presenters

import out.muravev.pv.contracts.MainContract

class ResultFragmentPresenterImpl(

    private val model: MainContract.SorterModel,
    private val view: MainContract.ResultFragment
) :
    MainContract.ResultFragmentPresenter {

    override fun onScreenOpened() {
        view.viewResultText(model.getUnsortedListResult())
    }

    override fun onBackButtonClicked() {
        view.backToMainFragment()
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