package out.muravev.pv.databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "strings_table")
class StringsEntity(
    val name: String,
    @PrimaryKey val id: Int
)
