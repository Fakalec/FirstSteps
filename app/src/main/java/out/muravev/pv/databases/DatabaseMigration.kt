package out.muravev.pv.databases

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_6_7 = object : Migration(7, 8) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // todo
//        database.execSQL("CREATE TABLE `string_table` (`name` TEXT NOT NULL, `date` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))")
    }
}

//                database.execSQL("ALTER TABLE `strin_date` ADD COLUMN `last_update` INTEGER")
//                (`name` TEXT NOT NULL, `date` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))")