package co.talesbruno.notes.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.talesbruno.notes.database.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val notesRepository: NotesRepository): ViewModel() {

    val notes: Flow<List<Note>> = notesRepository.allNotes()

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            notesRepository.delete(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            notesRepository.update(note)
        }
    }

    fun createNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            notesRepository.insert(note)
        }
    }
}