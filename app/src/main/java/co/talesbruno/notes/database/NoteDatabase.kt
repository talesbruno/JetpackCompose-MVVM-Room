package co.talesbruno.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.talesbruno.notes.models.Note
import co.talesbruno.notes.utils.DATABASE_NAME

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase(){

    abstract fun NoteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}