package out.muravev.pv.presenters

import android.content.Intent
import android.text.Editable
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import out.muravev.pv.adapters.RecyclerAdapter
import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.models.SorterModelImpl
import out.muravev.pv.views.ResultActivity
import out.muravev.pv.views.SorterActivity

class SorterPresenterImpl(
    private val model: SorterContract.SorterModel,
    private val view: SorterContract.SorterView,
    private val router: SorterContract.SorterRouter
) :
    SorterContract.SorterPresenter {

    override fun onAddButtonClicked() {
        if (model.setTypedText().isNotEmpty()) {
            model.setStringList().add(model.setTypedText())
            view.updateList(model.setStringList()) // ?
        } else {
            view.showEmptyEditToast()
        }
        view.updateEditText("")
    }

    override fun onSortButtonClicked() {
        if (model.setStringList().isNotEmpty()) {
            model.getSortedList(model.sortedStringList()) // todo
            router.openResultScreen()
//            val resultIntent = Intent(view.returnContext(), ResultActivity::class.java)
//            view.returnContext().startActivity(resultIntent)
            view.refreshAdapter(RecyclerAdapter(view.returnContext(), emptyList()))
        } else {
            view.showEmptyListToast()
        }
        view.updateEditText("")
    }

    override fun onTextEdited(text: String) {
        model.getTypedText(text)
    }
}