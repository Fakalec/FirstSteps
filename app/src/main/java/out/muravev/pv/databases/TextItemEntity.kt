package out.muravev.pv.databases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "strings")
class TextItemEntity(
    @ColumnInfo(name = "date")
    val date: Date,
    @ColumnInfo(name = "name")
    val name: String,
    @PrimaryKey val id: Int
)
