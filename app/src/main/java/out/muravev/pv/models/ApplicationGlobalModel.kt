package out.muravev.pv.models

import android.app.Application
import out.muravev.pv.algorithms.ListSort

class ApplicationGlobalModel : Application() {

    var listModel = SorterModelImpl(ListSort())
}