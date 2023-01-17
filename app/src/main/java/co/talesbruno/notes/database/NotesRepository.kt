package co.talesbruno.notes.database

import androidx.lifecycle.LiveData
import co.talesbruno.notes.models.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class NotesRepository(private val noteDao: NoteDao) {

    fun allNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }

    suspend fun update(note: Note){
        noteDao.update(note.id, note.title, note.note)
    }

}