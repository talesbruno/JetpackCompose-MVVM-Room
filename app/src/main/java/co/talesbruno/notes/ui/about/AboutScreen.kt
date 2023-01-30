package co.talesbruno.notes.ui.about

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.Lifecycle.State
import androidx.navigation.NavController
import co.talesbruno.notes.R
import co.talesbruno.notes.ui.menu.DrawerContent
import co.talesbruno.notes.ui.menu.DrawerHeader
import co.talesbruno.notes.ui.menu.MenuItem
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutScreen(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
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
                navController = navController
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(stringResource(R.string.about), style = MaterialTheme.typography.h4)
        }
    }
}
