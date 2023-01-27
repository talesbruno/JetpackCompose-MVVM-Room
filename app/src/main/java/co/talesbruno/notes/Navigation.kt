package co.talesbruno.notes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.talesbruno.notes.models.NoteViewModel
import co.talesbruno.notes.ui.about.AboutScreen
import co.talesbruno.notes.ui.home.HomeScreen

@Composable
fun Navigation(noteViewModel: NoteViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeScreen(
                noteViewModel = noteViewModel,
                navController = navController
            )
        }
        composable("about"){
            AboutScreen()
        }
    }
}