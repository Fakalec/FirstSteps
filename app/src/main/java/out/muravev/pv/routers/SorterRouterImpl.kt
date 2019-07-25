package out.muravev.pv.routers

import android.app.Activity
import android.content.Intent
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.views.ResultActivity
import out.muravev.pv.views.SorterActivity

class SorterRouterImpl(private var activity: Activity) : SorterContract.SorterRouter {
    override fun openResultScreen() {
        val resultIntent = Intent(activity, ResultActivity::class.java)
        activity.startActivity(resultIntent)
        activity.finish()
    }

    override fun returnToMainScreen() {
        val resultIntent = Intent(activity, SorterActivity::class.java)
        activity.startActivity(resultIntent)
        activity.finish()
    }
}