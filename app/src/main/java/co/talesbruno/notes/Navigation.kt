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

@Composable
fun Navigation(noteViewModel: NoteViewModel) {

    val navController = rememberNavController()

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeScreen(noteViewModel = noteViewModel, navController = navController, scope = scope, scaffoldState = scaffoldState)
        }
        composable("about"){
            AboutScreen(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    }
}