package co.talesbruno.notes.ui.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import androidx.navigation.NavController
import co.talesbruno.notes.models.Note
import co.talesbruno.notes.models.NoteViewModel
import co.talesbruno.notes.ui.home.components.NoteItem
import co.talesbruno.notes.ui.menu.DrawerContent
import co.talesbruno.notes.ui.menu.DrawerHeader
import co.talesbruno.notes.ui.menu.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "PrivateResource")
@Composable
fun HomeScreen(
    closeDrawer: () -> Unit,
    noteViewModel: NoteViewModel,
    navController: NavController,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {

    val notes by noteViewModel.notes.collectAsState(initial = listOf())
    val localContext = LocalContext.current

    var stateShowDialog by remember { mutableStateOf(false) }
    var titleField by remember { mutableStateOf("") }
    var textField by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            co.talesbruno.notes.ui.topappbar.TopAppBar(scope = scope, scaffoldState = scaffoldState)
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerHeader()
            DrawerContent(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "about",
                        title = "Sobre",
                        contentDescription = "Go to about screen",
                        icon = Icons.Default.Info
                    ),
                ),
                navController = navController,
                closeDrawer = closeDrawer
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
                    if(titleField.isEmpty() || textField.isEmpty()){
                        Toast.makeText(localContext, "Não pode cadastrar uma Nota vazia!", Toast.LENGTH_LONG).show()
                    }else{
                        noteViewModel.createNote(Note(0, titleField, textField))
                        titleField = ""
                        textField = ""
                        stateShowDialog = false}
                    },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.androidx_core_secondary_text_default_material_light))
            ) {
                Text(text = "Salvar", color = Color.White)
            }
            }
        )
    }
}





