package out.muravev.pv.models

import android.app.Application
import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.utils.DeviceCheckerUtil

class ApplicationGlobal : Application() {

    val deviceChecker = DeviceCheckerUtil(this)
    var listModel = MainModelImpl(ListSort())
}