package out.muravev.pv.models

import android.app.Application
import androidx.room.Room
import out.muravev.pv.algorithms.ListSort
//import out.muravev.pv.databases.DataBaseHandler
//import out.muravev.pv.databases.StringDataAccessor
import out.muravev.pv.databases.StringDataBase
import out.muravev.pv.utils.DeviceCheckerUtil

class ApplicationGlobal : Application() {

    private lateinit var db: StringDataBase
    val deviceChecker = DeviceCheckerUtil(this)
    lateinit var stringsModel: StringsModel

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, StringDataBase::class.java, "string.db").build()
        stringsModel = StringsModel(ListSort(), db)
        stringsModel.initModel()
    }

    override fun onTerminate() {
        super.onTerminate()
        stringsModel.release()
    }
}