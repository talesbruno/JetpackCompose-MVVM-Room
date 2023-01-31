package co.talesbruno.notes.ui.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DrawerContent(
    closeDrawer: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
){
    LazyColumn(modifier){
        items(items) { item ->
            Row(
                modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(item.id)
                        closeDrawer()
                    }
                    .padding(16.dp)
            ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription
                    )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f))
            }

    }
    }

}