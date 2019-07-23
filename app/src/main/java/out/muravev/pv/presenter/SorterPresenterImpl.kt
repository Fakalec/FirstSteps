package out.muravev.pv.presenter

import out.muravev.pv.ListSort
import out.muravev.pv.contract.SorterContract
import out.muravev.pv.model.SorterModelImpl

class SorterPresenterImpl(private val model: SorterModelImpl) : SorterContract.SorterPresenter {

    override fun cleanList() = model.savedText.clear()

    override fun getList() = model.savedText

    override fun sortList(listToSort: ArrayList<String>): ArrayList<String> {
        model.savedText = ListSort().getMergingBranchedLists(model.savedText) as ArrayList<String>
        return model.savedText
    }

    override fun pullString(inputEditText: String) {
        model.savedText.add(inputEditText)
    }
}