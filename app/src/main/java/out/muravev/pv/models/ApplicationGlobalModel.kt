package out.muravev.pv.models

import android.app.Application

class ApplicationGlobalModel : Application() {
    var listModel = SorterModelImpl()
}