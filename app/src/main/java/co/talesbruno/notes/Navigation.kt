package co.talesbruno.notes

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.talesbruno.notes.models.NoteViewModel
import co.talesbruno.notes.ui.about.AboutScreen
import co.talesbruno.notes.ui.home.HomeScreen
import kotlinx.coroutines.launch

@Composable
fun Navigation(noteViewModel: NoteViewModel) {

    val navController = rememberNavController()

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val openDrawer: () -> Unit = { scope.launch { scaffoldState.drawerState.open() } }
    val closeDrawer: () -> Unit = { scope.launch { scaffoldState.drawerState.close() } }

    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeScreen(noteViewModel = noteViewModel, navController = navController, scope = scope, scaffoldState = scaffoldState, closeDrawer = closeDrawer)
        }
        composable("about"){
            AboutScreen(navController = navController)
        }
    }
}