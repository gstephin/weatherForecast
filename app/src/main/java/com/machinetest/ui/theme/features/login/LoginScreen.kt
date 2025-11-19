package com.machinetest.ui.theme.features.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * LoginScreen
 *
 * @author stephingeorge
 * @date 18/11/2025
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    onLoggedIn: () -> Unit
) {
    Scaffold(

    ) {
        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        // --- Background gradient matching theme ---
        Surface {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 32.dp)
            ) {


                Text("Login", modifier = Modifier.padding(bottom = 24.dp))

                OutlinedTextField(
                    value = username,
                    onValueChange = {
                        username = it
                    },
                    label = { Text("Username") }

                )
                Spacer(Modifier.height(20.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text("Password") }
                )

                Button(onClick = onLoggedIn, modifier = Modifier.padding(top = 32.dp)) {
                    Text(text = "Login")


                }

            }
        }
    }
}