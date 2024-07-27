package aaa.android.jetpackcomposewidgets.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun WelcomeRoute() {
    WelcomeScreen()
}

@Composable
fun ProfileRoute(navController: NavHostController) {
    ProfileScreen(navController)
}