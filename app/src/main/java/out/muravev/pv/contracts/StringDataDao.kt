package out.muravev.pv.contracts

import androidx.room.*
import out.muravev.pv.databases.StringData

@Dao
interface StringDataDao {

    @Query("SELECT string_list FROM strings_table")
    fun getAllList(): List<String>

//    @Query("SELECT * FROM strings_table WHERE id = :id")
//    fun getById(id: Int)

    @Insert
    fun insert(vararg stringData: StringData)

    @Delete
    fun delete(stringData: StringData)
}