package aaa.android.jetpackcomposewidgets

import aaa.android.jetpackcomposewidgets.Destinations.WELCOME_ROUTE
import aaa.android.jetpackcomposewidgets.ui.screen.ProfileRoute
import aaa.android.jetpackcomposewidgets.ui.screen.WelcomeRoute
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


object Destinations {
    const val WELCOME_ROUTE = "welcome"
    const val SIGN_UP_ROUTE = "signup/{email}"
    const val SIGN_IN_ROUTE = "signin/{email}"
    const val SURVEY_ROUTE = "survey"
    const val SURVEY_RESULTS_ROUTE = "surveyresults"
}

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(),destination:String) {
    NavHost(
        navController = navController,
        startDestination = destination,
    ) {
        composable(WELCOME_ROUTE) {
            ProfileRoute(navController)
        }
        /*composable(WELCOME_ROUTE) {
            ProfileRoute(navController)
        }
        composable(WELCOME_ROUTE) {
            WelcomeRoute()
        }*/

    }
}
