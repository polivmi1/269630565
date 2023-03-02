package com.example.bug270656245.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination

@Destination(route = "two")
@Composable
fun TwoDestination(
    navController: NavController
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        OutlinedTextField(value = "aaa", onValueChange = {})
        Button(onClick = {
            navController.navigate("one") {
                popUpTo(NavGraphs.root.route)
                launchSingleTop = true
            }
        }) {
            Text("one")
        }
    }
}