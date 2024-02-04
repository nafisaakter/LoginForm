package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginform.ui.theme.LoginFormTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ExperimentalMaterialApi")
@Composable
fun LoginForm() {
    var username by remember { mutableStateOf("") }
    val purpleColor = Color(0xFF6200EE)
    var password by remember { mutableStateOf("") }

    // Define custom TextFieldColors
    val customTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
         // Set text color to purple
        focusedBorderColor = purpleColor, // Set border color to purple when focused
        unfocusedBorderColor = purpleColor, // Set border color to purple when unfocused
    )
//    val customButtonColors = ButtonDefaults.buttonColors(
//        backgroundColor = purpleColor, // Set button background color to purple
//        contentColor = Color.White // Set button text color to white
//    )

    val titleFontWeight = FontWeight.Bold
    Column(
        modifier = Modifier
            .padding(8.dp)


    ) {
        Text(
            text = "Login",
//            color = MaterialTheme.colorScheme.primary,
            fontSize = 30.sp,
            color = purpleColor,
            textAlign = TextAlign.Left,
            fontWeight = titleFontWeight,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(value = username, onValueChange = {username=it},
            label = {
                Box(
                    contentAlignment = Alignment.CenterStart, // Align content in the middle of the border
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "username",
                        color = purpleColor
                    )
                }
                    },
            singleLine = true,
            colors=customTextFieldColors,
            modifier = Modifier.fillMaxWidth(),
            )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = stringResource(R.string.password),
                    color = purpleColor
                )
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            colors = customTextFieldColors,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Button(
            onClick = { /* Handle login */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = purpleColor,
                contentColor = Color.White
            ), // Apply custom button colors
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Submit")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    LoginFormTheme {
        LoginForm()
    }
}
