//package co.talesbruno.notes.ui.home.components
//
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.State
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import co.talesbruno.notes.models.Note
//import co.talesbruno.notes.models.NoteViewModel
//import co.talesbruno.notes.ui.theme.NotesTheme
//
//@Composable
//fun NoteList(noteViewModel: NoteViewModel){
//
//    val notes by noteViewModel.notes.collectAsState(initial = listOf())
//
//    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
//        items(items = notes){ note ->
//            NoteItem(
//                note = note,
//                noteViewModel = noteViewModel
//            )
//        }
//    }
//}
//
