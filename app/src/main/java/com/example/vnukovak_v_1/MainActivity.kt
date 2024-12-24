@file:Suppress("DEPRECATION")

package com.example.vnukovak_v_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

private fun Any.SettingSwitch(s: String, switchState1: Boolean) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text("Авторизация", fontSize = 20.sp, color = Color.Gray)

        Image(
            painter = painterResource(id = R.drawable.orange_cat_in_spacesuit),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        @Composable
        fun LoginScreen() {
            var login by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Cat Image
                Image(
                    painter = painterResource(id = R.drawable.orange_cat_in_spacesuit),
                    contentDescription = "Cat Astronaut",
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))


                Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Пароль") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500))
        ) {
            Text("Авторизоваться", color = Color.White)
        }
    }
}
@Composable
fun ProfileScreen(userName: String, onLogoutClick: () -> Unit, onSettingsClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.ic_globe), contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Станция", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(painterResource(id = R.drawable.ic_search), contentDescription = null)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Привет, user", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {            Column(modifier = Modifier.padding(16.dp)) {
            Text("Ты запустил ракету")
            Text("22 декабря, в 11:20", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle snapshot action */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Сделать снимок", color = Color.White)
            }
        }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painterResource(id = R.drawable.ic_hands_clock), contentDescription = null, modifier = Modifier.size(60.dp))

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text("Сегодня состоялся запуск ракеты на станции Земля-1")
                Text("22 декабря, в 11:20", fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onLogoutClick,
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Выйти")
            }

            Button(
                onClick = onSettingsClick,
                modifier = Modifier.weight(1f).padding(start = 8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Настройки")
            }
        }
    }
}

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.ic_back_arrow), contentDescription = null, modifier = Modifier.clickable(onClick = onBackClick))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Настройки", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        val switchState1: Boolean by remember { mutableStateOf(false) }
        val switchState2: Boolean by remember { mutableStateOf(false) }
        val switchState3: Boolean by remember { mutableStateOf(false) }

        // Переключатели
        SettingSwitch("Отображать мое местоположение", switchState1)
        SettingSwitch("Уведомлять меня о новом запуске", switchState2)
        SettingSwitch("Отображать последние новости", switchState3)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Техническая поддержка")
                Text("support.fox.ru", color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* Reset settings */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500))
        ) {
            Text("Сбросить настройки", color = Color.White)
        }
    }
}

fun Card(
    modifier: Modifier,
    shape: RoundedCornerShape,
    backgroundColor: Color,
    elevation: Dp,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    TODO("Not yet implemented")
}

@Composable
fun SettingSwitch(label: String, isChecked: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical=8.dp),
        verticalAlignment = Alignment.CenterVertically,        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)

        Switch(
            checked = isChecked,
            onCheckedChange = { /* Handle switch change */ },
            colors= SwitchDefaults.colors(checkedThumbColor= Color(0xFFFFA500))
        )
    }
}

    }
}
