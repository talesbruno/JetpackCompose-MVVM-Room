package co.talesbruno.notes.ui.home.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.R
import co.talesbruno.notes.models.Note
import co.talesbruno.notes.models.NoteViewModel
import kotlin.random.Random

@Composable
fun NoteItem(
    note: Note,
    noteViewModel: NoteViewModel
){
    var stateShowDialog by remember{ mutableStateOf(false) }
    var stateShowItemDialog by remember{ mutableStateOf(false) }

    val localContext = LocalContext.current

    var titleField by remember { mutableStateOf(note.title) }
    var textField by remember { mutableStateOf(note.note) }

   Surface(color = Color.Companion.random(),
       modifier = Modifier
           .padding(vertical = 4.dp, horizontal = 8.dp)
           .clickable { stateShowItemDialog = true }
   ) {
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = note.title)
                    Text(text = note.note, maxLines = 2, overflow = TextOverflow.Ellipsis,style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.ExtraBold))
                }
                IconButton(onClick = { noteViewModel.deleteNote(note)}) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
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
                                if(titleField.isEmpty() || textField.isEmpty()){
                                    Toast.makeText(localContext, "Não pode cadastrar uma Nota vazia!", Toast.LENGTH_LONG).show()
                                }else{
                                    noteViewModel.updateNote(Note(note.id, titleField, textField))
                                    stateShowDialog = false }
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.androidx_core_secondary_text_default_material_light))
                        ) {
                            Text(text = "Salvar", color = Color.White)
                        }
                        }
                    )
                }
                if (stateShowItemDialog){
                    AlertDialog(
                        backgroundColor = Color.Companion.random(),
                        onDismissRequest = { stateShowItemDialog = false },
                        title = { Text(text = note.title)},
                        text = { Text(text = note.note)},
                        confirmButton = {
                            IconButton(onClick = { stateShowItemDialog = false }) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = null)
                            }
                        }
                    )
                }
            }
        }
}
}

@Composable
fun Color.Companion.random() : Color {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color(red, green, blue)
}
