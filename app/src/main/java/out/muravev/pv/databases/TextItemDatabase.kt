package out.muravev.pv.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import out.muravev.pv.data.DateConverter

@Database(entities = [TextItemEntity::class], version = 17, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class TextItemDatabase : RoomDatabase() {

    abstract fun stringDao(): TextItemDao
}