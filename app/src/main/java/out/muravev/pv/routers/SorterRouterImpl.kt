package out.muravev.pv.routers

import android.content.Intent
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.views.ResultActivity

class SorterRouterImpl(private val view: SorterContract.SorterView) : SorterContract.SorterRouter {
    override fun openResultScreen() {
        val resultIntent = Intent(view.returnContext(), ResultActivity::class.java) // ? использование контекста вью
        view.returnContext().startActivity(resultIntent)
    }
}