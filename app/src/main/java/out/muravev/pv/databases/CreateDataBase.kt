package out.muravev.pv.databases

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.ID
import out.muravev.pv.models.MainModelImpl

class DataBaseHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    private val CREATE_STRING_TABLE = ("CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $STRING_TEXT)")
    private val DROP_STRING_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_STRING_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_STRING_TABLE)
        onCreate(db)
    }
    fun insertString(item: String) {
        val db = this.writableDatabase
        val res = db.rawQuery("select * from $TABLE_NAME, null")
        while (res.moveToNext()) {

        }
    }
}