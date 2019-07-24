package out.muravev.pv.Routers

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.views.ResultActivity
import out.muravev.pv.views.SorterActivity

class SorterRouterImpl(private val view: SorterContract.SorterView): SorterContract.SorterRouter{
    override fun openResultScreen() {
        val resultIntent = Intent(view.returnContext(), ResultActivity::class.java)
//        view.returnIntent(resultIntent)
        view.returnContext().startActivity(resultIntent)
    }
}