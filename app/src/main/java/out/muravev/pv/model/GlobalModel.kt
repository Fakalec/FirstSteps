package out.muravev.pv.model

import android.app.Application

class GlobalModel : Application() {
    var listModel = SorterModelImpl()
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


