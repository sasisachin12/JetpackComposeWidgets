package aaa.android.jetpackcomposewidgets.ui.screen

import aaa.android.jetpackcomposewidgets.Destinations.SCREEN_ONE
import aaa.android.jetpackcomposewidgets.theme.JetPackComposeWidgetsTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    JetPackComposeWidgetsTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "Profile",
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                )
            },
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    /* Box(
                         modifier = Modifier.fillMaxWidth()
                             .height(200.dp)
                             .padding(horizontal = 15.dp, vertical = 10.dp)
                             .clip(MaterialTheme.shapes.large)
                     ) {
                         Image(
                             painter = painterResource(R.drawable.three),
                             contentDescription = "profile_screen_bg",
                             contentScale = ContentScale.Crop
                         )
                     }*/
                    Button(onClick = { navController.navigate(SCREEN_ONE) }) {
                        Text("Navigate Screen One")
                    }
                }
            }
        }


    }
}

