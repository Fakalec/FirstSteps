package out.muravev.pv.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import out.muravev.pv.data.DateConverter

@Database(entities = [StringsEntity::class], version = 5, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class StringDatabase : RoomDatabase() {

    abstract fun stringDao(): StringDataDao
}