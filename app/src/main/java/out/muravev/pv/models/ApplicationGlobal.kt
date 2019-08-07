package out.muravev.pv.models

import android.app.Application
import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.routers.DeviceCheckerImpl

class ApplicationGlobal : Application() {

    val deviceChecker = DeviceCheckerImpl(this)
    var listModel = MainModelImpl(ListSort())
}