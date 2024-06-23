package project.elite.chatapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import project.elite.chatapplication.bottombar.BottomBar
import project.elite.chatapplication.navigation.MainNavController
import project.elite.chatapplication.navigation.Screens
import project.elite.chatapplication.screens.ChatScreen
import project.elite.chatapplication.screens.HomeScreen
import project.elite.chatapplication.screens.StartScreen
import project.elite.chatapplication.signin.SignInScreen
import project.elite.chatapplication.ui.theme.ChatApplicationTheme

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val bottomBarState = rememberSaveable { mutableStateOf(true) }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    navBackStackEntry?.destination?.route?.let { route ->
                        bottomBarState.value = when (route) {
                            Screens.HomeScreen.route,
                            Screens.ProfileScreen.route ->true
                            else -> false
                        }
                    }

                    Scaffold(
                        bottomBar = {
                            BottomBar(
                                navController = navController,
                                bottomBarState = bottomBarState
                            )
                        }
                    ) {
                        val scaffoldState = rememberScaffoldState()
                        MainNavController(
                            navController
                        )
                    }
                }
            }
        }
    }
}
