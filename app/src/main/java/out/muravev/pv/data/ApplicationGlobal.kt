package out.muravev.pv.data

import android.app.Application
import androidx.room.Room
import out.muravev.pv.databases.MIGRATION_4_5
import out.muravev.pv.databases.StringDatabase
import out.muravev.pv.utils.DeviceCheckerUtil

class ApplicationGlobal : Application() {

    private lateinit var database: StringDatabase
    val deviceChecker = DeviceCheckerUtil(this)
    lateinit var stringsModel: StringsModel

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(this, StringDatabase::class.java, "string.db").addMigrations(MIGRATION_4_5).build()
        stringsModel = StringsModel(ListMergeSortAlgo(), database)
        stringsModel.initModel()
    }

    override fun onTerminate() {
        super.onTerminate()
        stringsModel.release()
    }
}