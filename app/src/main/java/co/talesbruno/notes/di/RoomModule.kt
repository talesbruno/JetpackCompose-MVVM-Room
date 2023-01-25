package co.talesbruno.notes.di

import android.app.Application
import co.talesbruno.notes.database.NoteDao
import co.talesbruno.notes.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule{

    @Singleton
    @Provides
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return NoteDatabase.getDatabase(app)
    }
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.NoteDao()
    }
}