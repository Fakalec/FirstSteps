package out.muravev.pv.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import out.muravev.pv.contracts.StringDataDao

@Database(entities = [StringData::class], version = 1, exportSchema = false)

abstract class StringDataBase : RoomDatabase() {

    abstract fun stringDao(): StringDataDao
}