package out.muravev.pv.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TextItemDao {

    @Query("SELECT * FROM string_date")
    fun getAllStrings(): List<TextItemEntity>

    @Query("DELETE FROM string_date WHERE id == :position")
    fun deleteOnPosition(position: Int)

    @Insert
    fun insertString(stringData: TextItemEntity)

    @Query("DELETE FROM string_date")
    fun deleteAllStrings()
}