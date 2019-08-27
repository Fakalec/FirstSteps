package out.muravev.pv.databases

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration17to18 : Migration(17, 18) {
    override fun migrate(database: SupportSQLiteDatabase) {
        val tempTableName = "TempStrings"
        val tableName = "Strings"
        database.execSQL("CREATE TABLE IF NOT EXISTS `$tempTableName` (`name` TEXT NOT NULL, `date` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        database.execSQL("INSERT INTO $tempTableName (name, date, id) SELECT name, date, id FROM $tableName")
        database.execSQL("DROP TABLE $tableName")
        database.execSQL("ALTER TABLE $tempTableName RENAME TO $tableName")
    }
}