package out.muravev.pv

import android.app.Application
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
//
class GlobalSortList : Application() {
    var sortedList: List<String> = listOf()
    var listToFill = ArrayList<String>()
}