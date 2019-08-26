package out.muravev.pv.databases

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_4_5 = object : Migration(4, 5) {
    override fun migrate(database: SupportSQLiteDatabase) {
    }
}

//                database.execSQL("ALTER TABLE `strin_date` ADD COLUMN `last_update` INTEGER")
//                (`name` TEXT NOT NULL, `date` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))")
