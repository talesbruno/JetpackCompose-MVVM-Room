package co.talesbruno.notes.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.R
import co.talesbruno.notes.models.Note
import co.talesbruno.notes.models.NoteViewModel

@Composable
fun NoteItem(
    note: Note,
    noteViewModel: NoteViewModel
){
    var stateShowDialog by remember{ mutableStateOf(false) }
    var titleField by remember { mutableStateOf(note.title) }
    var textField by remember { mutableStateOf(note.note) }

   Surface(color = MaterialTheme.colors.primary,
       modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
   ) {
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = note.title)
                    Text(text = note.note, style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.ExtraBold))
                }
                IconButton(onClick = { noteViewModel.deleteNote(note)}) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
                IconButton(onClick = { stateShowDialog = true }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
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
                                noteViewModel.updateNote(Note(note.id, titleField, textField))
                                stateShowDialog = false } ,
                                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.androidx_core_secondary_text_default_material_light))
                        ) {
                            Text(text = "Salvar", color = Color.White)
                        }
                        }
                    )
                }
            }
        }
}
}
