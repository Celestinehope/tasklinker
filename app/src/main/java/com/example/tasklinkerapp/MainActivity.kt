package com.example.tasklinkerapp

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasklinkerapp.ui.theme.TaskLinkerAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreen()
        }
    }

}



@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.LoginView) }

    when (currentScreen) {
        Screen.LoginView -> {
            LoginView(currentScreen) {
                currentScreen = it
            }
        }
        Screen.RegisterView -> {
            RegisterView {
                currentScreen = Screen.LoginView
            }
        }
        Screen.ForgotPasswordView -> {
            ForgotPasswordView {
                currentScreen = Screen.LoginView
            }
        }
    }
}

enum class Screen {
    LoginView,
    RegisterView,
    ForgotPasswordView
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(currentScreen: Screen, onSwitchScreen: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = " TASK-LINKER",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        )


        Text(
            text = "Task Management App",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )
        Text(
            text = "Login to your account",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Row (

        )
        {
            Image (
                painter = painterResource(id = R.drawable.emaillogo),
                contentDescription = null,
                modifier = Modifier.size(55.dp)

            )
            var input = rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = input.value,
                onValueChange = {input.value = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) }

        Row (

        )
        { Spacer(modifier = Modifier.height(20.dp))
            Image (
                painter = painterResource(id = R.drawable.locklogo),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .alignByBaseline()
            )
            var password = rememberSaveable { mutableStateOf("") }
            OutlinedTextField(

                visualTransformation = PasswordVisualTransformation(),
                value = password.value ,
                onValueChange = { password.value = it },
                label = { Text("Password") },
                modifier = Modifier
                    .alignByBaseline()
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) }
        Row (
        )
        {
            Spacer(modifier = Modifier.width(230.dp))
            Text(
                text = "Forgot password?",
                color = Color.Blue,
                modifier = Modifier.clickable { onSwitchScreen(Screen.ForgotPasswordView)},
            )
        }

        Button (
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor =  Color.Blue)
        ){
            Text(
                text = "LOGIN"
            )
        }
        Spacer(modifier = Modifier.size(100.dp))
        Text (
            text = "- or login with -",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.facebooklogo),
                contentDescription = null,
                modifier = Modifier.size(56.dp)

            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.googlelogo),
                contentDescription = null,
                modifier = Modifier.size(64.dp)


            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.twitterlogo),
                contentDescription = null,
                modifier = Modifier.size(70.dp)

            )
        }
        Text(
            text = "Don't have an account? Sign Up",
            color = Color.Blue,
            modifier = Modifier.clickable {  onSwitchScreen(Screen.RegisterView)}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(onSwitchScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = " TASK-LINKER",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )

        )
        Text(
            text = "Task Management App",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )
        Text(
            text = "Create your account",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )
        Row (

        )
        {
            Image (
                painter = painterResource(id = R.drawable.profilelogo),
                contentDescription = null,
                modifier = Modifier.size(55.dp)

            )
            var username = rememberSaveable { mutableStateOf("") }
            TextField(
                value = username.value,
                onValueChange = { username.value = it},
                label = { Text("Username") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        Row (

        )
        {
            Image (
                painter = painterResource(id = R.drawable.emaillogo),
                contentDescription = null,
                modifier = Modifier.size(55.dp)

            )
            var email = rememberSaveable { mutableStateOf("") }
            TextField(
                value = email.value,
                onValueChange = {email.value = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) }

        Row (

        )
        {
            Image (
                painter = painterResource(id = R.drawable.locklogo),
                contentDescription = null,
                modifier = Modifier.size(55.dp)

            )
            var password = rememberSaveable { mutableStateOf("") }
            TextField(
                value = password.value,
                onValueChange = {password.value = it},
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) }

        Row (

        )
        {
            Image (
                painter = painterResource(id = R.drawable.locklogo),
                contentDescription = null,
                modifier = Modifier.size(55.dp)

            )
            var confirmpassword = rememberSaveable { mutableStateOf("") }
            TextField(
                value = confirmpassword.value,
                onValueChange = {confirmpassword.value = it},
                label = { Text("Confirm Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) }

        Row (
        )
        {
            Spacer(modifier = Modifier.width(175.dp))
            Text(
                text = "Already registered, Login here",
                color = Color.Blue,
                modifier = Modifier.clickable {onSwitchScreen()},
            )
        }

        Button (
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor =  Color.Blue)
        ){
            Text(
                text = "Register"
            )
        }
        Spacer(modifier = Modifier.size(100.dp))
        Text (
            text = "- or Register with -",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.facebooklogo),
                contentDescription = null,
                modifier = Modifier.size(56.dp)

            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.googlelogo),
                contentDescription = null,
                modifier = Modifier.size(64.dp)


            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.twitterlogo),
                contentDescription = null,
                modifier = Modifier.size(64.dp)

            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordView(onSwitchScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Forgot Password",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )

        // Add your forgot password UI components here

        Row {
            Text(
                text = "Remember your password? Login here",
                color = Color.Blue,
                modifier = Modifier.clickable { onSwitchScreen() },
            )
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.googlelogo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop

    )
    LaunchedEffect(true ){
        delay(2000)
        onTimeout()
    }
}