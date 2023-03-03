package com.example.bug270656245.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.rememberNavController
import com.example.bug270656245.ui.screens.NavGraphs
import com.example.bug270656245.ui.screens.destinations.OneDestinationDestination
import com.example.bug270656245.ui.screens.destinations.TwoDestinationDestination
import com.example.bug270656245.ui.theme.Bug270656245Theme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.NestedNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.manualcomposablecalls.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bug270656245Theme {
                var native by remember { mutableStateOf(false) }
                Scaffold(
                    topBar = {
                        Button(onClick = {
                            native = !native
                        }) {
                            Text("native: $native")
                        }
                    },
                    content = { scaffoldPadding ->
                        Box(Modifier.padding(scaffoldPadding)) {
                            if (native) {
                                val navController = rememberAnimatedNavController()
                                AnimatedNavHost(
                                    navController = navController,
                                    startDestination = "one",
                                    contentAlignment = Alignment.TopCenter,
                                ) {
                                    composable("one") { One(navController) }
                                    composable("two") { Two(navController) }
                                }
                            } else {
                                val navController = rememberAnimatedNavController()
                                val navHostEngine = rememberAnimatedNavHostEngine(
                                    navHostContentAlignment = Alignment.TopCenter,
                                    rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING,
                                    defaultAnimationsForNestedNavGraph = mapOf(
                                        NavGraphs.root to NestedNavGraphDefaultAnimations(
                                            enterTransition = { slideInHorizontally() },
                                            exitTransition = { slideOutHorizontally() }
                                        ),
                                    ))
                                DestinationsNavHost(
                                    navGraph = NavGraphs.root,
                                    navController = navController,
                                    engine = navHostEngine
                                )
                                {
                                    composable(OneDestinationDestination) {
                                        OneDestination(navController)
                                    }
                                    composable(TwoDestinationDestination) {
                                        TwoDestination(navController)
                                    }
                                }
                            }
                        }
                    })
            }
        }
    }

    @Composable
    fun One(navController: NavController) {
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
                navController.navigate("two")
            }) {
                Text("two")
            }
        }
    }


    @Composable
    fun Two(navController: NavController) {
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
            Button(onClick = { navController.navigate("one") }) {
                Text("one")
            }
        }
    }
}


