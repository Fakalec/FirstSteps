package out.muravev.pv.presenter

import android.app.Application
import android.graphics.ColorSpace
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.ListSort
import out.muravev.pv.RecyclerAdapter
import out.muravev.pv.SorterContract
import out.muravev.pv.model.SorterModelImpl

class SorterPresenterImpl(_view: SorterContract.SorterView) : Application(), SorterContract.SorterPresenter {

    override val filledList: ArrayList<String>
        get() = model.savedText
//    private var view: SorterContract.SorterView = _view
    private var model: SorterContract.SorterModel = SorterModelImpl()

    override fun sortList(listToSort: ArrayList<String>) {
        ListSort().getMergingBranchedLists(model.savedText)
    }

    override fun fillList(inputEditText: String) {
        model.saveEditText(inputEditText)
    }

//    override fun cleanList() {
//
//    }
}