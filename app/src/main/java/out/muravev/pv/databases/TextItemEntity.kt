package out.muravev.pv.databases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "string_date")
class TextItemEntity( // todo
    @ColumnInfo(name = "date")
    val date: Date,
    @ColumnInfo(name = "name")
    val name: String,

    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
