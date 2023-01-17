package co.talesbruno.notes.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import co.talesbruno.notes.models.Note
import co.talesbruno.notes.models.NoteViewModel
import co.talesbruno.notes.ui.home.components.NoteItem



@Composable
fun HomeScreen(noteViewModel: NoteViewModel) {

    val notes by noteViewModel.notes.collectAsState(initial = listOf())

    var stateShowDialog by remember { mutableStateOf(false) }
    var titleField by remember { mutableStateOf("") }
    var textField by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notas") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { stateShowDialog = true }) {
                Icon(imageVector = Icons.Default.Add , contentDescription = null)
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
            items(items = notes){ note ->
                NoteItem(note = note, noteViewModel = noteViewModel)
            }
        }
    }

    if (stateShowDialog){
        AlertDialog(
            onDismissRequest = { stateShowDialog = false },
            title = { Text(text = "Nota")},
            text = {
                   Column(modifier = Modifier.padding(16.dp)) {
                       OutlinedTextField(
                           value = titleField,
                           label = { Text(text = "Digite o titulo") },
                           onValueChange = { titleField = it }
                       )
                       OutlinedTextField(
                           value = textField,
                           label = { Text(text = "Digite sua Nota") },
                           onValueChange = { textField = it }
                       )
                   }
            },
            confirmButton = {
                Button(onClick = {
                    noteViewModel.createNote(Note(0, titleField, textField))
                    titleField = ""
                    textField = ""
                    stateShowDialog = false} ,
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.androidx_core_secondary_text_default_material_light))
            ) {
                Text(text = "Salvar", color = Color.White)
            }
            }
        )
    }
}





