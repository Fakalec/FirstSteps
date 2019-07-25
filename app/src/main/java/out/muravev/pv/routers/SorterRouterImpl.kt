package out.muravev.pv.routers

import android.app.Activity
import android.content.Intent
import out.muravev.pv.contracts.SorterContract
import out.muravev.pv.views.ResultActivity
import out.muravev.pv.views.SorterActivity

class SorterRouterImpl(var activity: Activity) : SorterContract.SorterRouter {
    override fun openResultScreen() {
        val resultIntent = Intent(activity, ResultActivity::class.java) // ? использование контекста вью
        activity.startActivity(resultIntent)
    }

    override fun returnToMainScreen() {
        val resultIntent = Intent(activity, SorterActivity::class.java)
        activity.startActivity(resultIntent)
    }
}