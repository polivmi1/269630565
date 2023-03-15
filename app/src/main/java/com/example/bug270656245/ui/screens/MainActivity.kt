package com.example.bug270656245.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bug270656245.ui.theme.Bug270656245Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bug270656245Theme {
                Scaffold(
                    content = { scaffoldPadding ->
                        Box(Modifier.padding(scaffoldPadding)) {
                                val navController = rememberNavController()
                                NavHost(
                                    navController = navController,
                                    startDestination = "one",
                                ) {
                                    composable("one") { One(navController) }
                                    composable("two") { Two(navController) }
                                }
                        }
                    })
            }
        }
    }

    @Composable
    fun One(navController: NavController) {
        Column {
            Button(onClick = {
                navController.navigate("two") {
                }
            }) {
                Text("Go to next navigation to select text and press back")
            }
        }
    }


    @Composable
    fun Two(navController: NavController) {
        SelectionContainer {
            Text(
                text = "Some text to select",
            )
        }
    }
}


