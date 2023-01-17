package co.talesbruno.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import co.talesbruno.notes.database.NoteDatabase
import co.talesbruno.notes.database.NotesRepository
import co.talesbruno.notes.models.NoteViewModel
import co.talesbruno.notes.models.NoteViewModelFactory
import co.talesbruno.notes.ui.home.HomeScreen

import co.talesbruno.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = NoteDatabase.getDatabase(application).NoteDao()
        val repository = NotesRepository(dao)
        val factory = NoteViewModelFactory(repository)
        noteViewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        setContent {
            NotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(noteViewModel = noteViewModel)
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NotesTheme {
//        Surface(modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colors.background)
//        {
//            HomeScreen(noteViewModel = noteViewModel)
//        }
//    }
//}




