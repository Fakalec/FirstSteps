package out.muravev.pv.models

import android.app.Application
import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.routers.DeviceChecker

class ApplicationGlobal : Application() {

    val deviceChecker = DeviceChecker(this)
    var listModel = MainModelImpl(ListSort())
}