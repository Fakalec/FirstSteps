package out.muravev.pv.databases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "strings_table")
class StringData(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo(name = "string_list") var stringItem: String
)
