package co.talesbruno.notes.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import co.talesbruno.notes.database.NoteDao
import co.talesbruno.notes.database.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NoteViewModel(private val notesRepository: NotesRepository): ViewModel() {

//    private val _selectedNoteState: MutableState<Note?> = mutableStateOf(null)
//    val selectedNoteState: State<Note?>
//        get() = _selectedNoteState

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

class NoteViewModelFactory(
    private val NotesRepository: NotesRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(notesRepository = NotesRepository) as T
    }
}