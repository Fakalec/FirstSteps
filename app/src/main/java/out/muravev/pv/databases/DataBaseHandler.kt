package out.muravev.pv.databases
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//
//class DataBaseHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
//
//    companion object {
//        const val DB_VERSION = 42
//        const val DB_NAME = "STRDB.db"
//        const val TABLE_NAME = "Strings"
//        const val NEW_STRING = "StringItem"
//        const val ID = "id"
//
//        // creationDate Date todo
//        private const val CREATE_STRING_TABLE =
//            ("CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NEW_STRING TEXT)")
//        private const val DROP_STRING_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
//    }
//
//
//    override fun onCreate(db: SQLiteDatabase) {
//        db.execSQL(CREATE_STRING_TABLE)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL(DROP_STRING_TABLE)
//        onCreate(db)
//    }
//}