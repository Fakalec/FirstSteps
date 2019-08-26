package out.muravev.pv.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StringDataDao {

    @Query("SELECT * FROM strin_date")
    fun getAllStrings(): List<StringsEntity>

    @Query("DELETE FROM strin_date WHERE id == :position")
    fun deleteOnPosition(position: Int)

    @Insert
    fun insertString(stringData: StringsEntity)

    @Query("DELETE FROM strin_date")
    fun deleteAllStrings()
}