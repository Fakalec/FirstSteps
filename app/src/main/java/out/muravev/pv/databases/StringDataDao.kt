package out.muravev.pv.databases

import androidx.room.*
import out.muravev.pv.databases.StringsEntity

@Dao
interface StringDataDao {

    @Query("SELECT * FROM strings_table")
    fun getAllStrings(): List<StringsEntity>

    @Query("DELETE FROM strings_table WHERE id == :position")
    fun deleteOnPosition(position: Int)

    @Insert
    fun insertString(stringData: StringsEntity)

    @Query("DELETE FROM strings_table")
    fun deleteAllStrings()
}