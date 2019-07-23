package out.muravev.pv

import android.app.Application
import out.muravev.pv.model.SorterModelImpl

class GlobalModel : Application() {
    var model = SorterModelImpl()
}

//import android.app.Application
//import dagger.Component
//import javax.inject.Inject
//
//@Component
//interface MagicBox {
//    fun poke(app: SorterActivity)
//}
//
//class Info @Inject constructor() {
//    val text = "Hello Sorter!"
//}


