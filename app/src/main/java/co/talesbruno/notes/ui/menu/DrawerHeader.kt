package co.talesbruno.notes.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import co.talesbruno.notes.R

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DrawerHeader(modifier: Modifier = Modifier) {

    Column(modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier
                .clip(CircleShape)
                .width(150.dp)
                .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
        )
        Text(text = "teste@gmail.com", fontSize = TextUnit(14F, TextUnitType.Sp), color = Color.White)
        Divider(color = Color.LightGray)
    }
}