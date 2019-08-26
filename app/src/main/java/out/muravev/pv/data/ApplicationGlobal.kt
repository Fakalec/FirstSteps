package out.muravev.pv.data

import android.app.Application
import androidx.room.Room
//import out.muravev.pv.databases.MIGRATION_7_8
import out.muravev.pv.databases.TextItemDatabase
import out.muravev.pv.utils.DeviceCheckerUtil

class ApplicationGlobal : Application() {

    private lateinit var database: TextItemDatabase
    val deviceChecker = DeviceCheckerUtil(this)
    lateinit var textItemModel: TextItemModel

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(this, TextItemDatabase::class.java, "string.db").fallbackToDestructiveMigration().build()
        textItemModel = TextItemModel(ListMergeSortAlgo(), database)
        textItemModel.initModel()
    }

    override fun onTerminate() {
        super.onTerminate()
        textItemModel.release()
    }
}