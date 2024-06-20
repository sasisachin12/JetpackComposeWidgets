package aaa.android.jetpackcomposewidgets.ui.navigation

sealed class Screen(val route : String) {
    data object Home : Screen("home_screen")
    data object Search : Screen("search_screen")
    data object Profile : Screen("profile_screen")
}