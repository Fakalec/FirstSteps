package out.muravev.pv.data

import androidx.room.Database
import androidx.room.RoomDatabase
import out.muravev.pv.databases.StringDataDao
import out.muravev.pv.databases.StringsEntity

@Database(entities = [StringsEntity::class], version = 11, exportSchema = false)

abstract class StringDataBase : RoomDatabase() {

    abstract fun stringDao(): StringDataDao
}