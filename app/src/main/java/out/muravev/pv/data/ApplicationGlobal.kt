package out.muravev.pv.data

import android.app.Application
import androidx.room.Room
//import out.muravev.pv.databases.DataBaseHandler
//import out.muravev.pv.databases.StringDataAccessor
import out.muravev.pv.utils.DeviceCheckerUtil

class ApplicationGlobal : Application() {

    private lateinit var database: StringDataBase
    val deviceChecker = DeviceCheckerUtil(this)
    lateinit var stringsModel: StringsModel


    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, StringDataBase::class.java, "string.db").fallbackToDestructiveMigration().build()
        stringsModel = StringsModel(ListMergeSortAlgo(), database)
        stringsModel.initModel()
    }

    override fun onTerminate() {
        super.onTerminate()
        stringsModel.release()
    }
}