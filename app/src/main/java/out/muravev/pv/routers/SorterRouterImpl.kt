package out.muravev.pv.routers

import android.app.Activity
import android.content.Intent
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.views.ResultActivity

class SorterRouterImpl(private var activity: Activity) : SorterContract.SorterRouter {

    override fun openResultScreen() {
        val resultIntent = Intent(activity, ResultActivity::class.java)
        activity.startActivity(resultIntent)
    }

    override fun returnToMainScreen() {
        activity.finish()
    }
}