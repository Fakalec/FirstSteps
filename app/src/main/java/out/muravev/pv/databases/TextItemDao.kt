package out.muravev.pv.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TextItemDao {

    @Query("SELECT * FROM strings")
    fun getAllStrings(): List<TextItemEntity>

    @Query("DELETE FROM strings WHERE id == :position")
    fun deleteOnPosition(position: Int)

    @Insert
    fun insertString(stringData: TextItemEntity)

    @Query("DELETE FROM strings")
    fun deleteAllStrings()
}