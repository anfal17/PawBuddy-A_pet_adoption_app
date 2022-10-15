package com.example.pawbuddy

import android.os.Bundle
import android.telecom.Call
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.pawbuddy.data.CatData
import com.example.pawbuddy.data.PetList
import com.example.pawbuddy.ui.screen.DetailsScreen
import com.example.pawbuddy.ui.screen.HomeScreen
import com.example.pawbuddy.ui.theme.PawBuddyTheme
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawBuddyTheme {
                App()
            }
        }
    }
}


@Composable
fun  App() {
    //adding NavController

    var navController : NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "details/{catIndex}",arguments = listOf(navArgument("catIndex"){type = NavType.IntType})){
            val catIndex = it.arguments?.getInt("catIndex") ?: 0
            DetailsScreen(navController , CatData = PetList[catIndex])
        }
    }
}








@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PawBuddyTheme {
        App()
    }
}