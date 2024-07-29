package aaa.android.jetpackcomposewidgets.ui.screen

import aaa.android.jetpackcomposewidgets.R
import aaa.android.jetpackcomposewidgets.theme.JetPackComposeWidgetsTheme
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenOne(navController: NavHostController) {
    val showBranding by rememberSaveable { mutableStateOf(true) }

    Scaffold(modifier = Modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            AnimatedVisibility(
                showBranding,
                Modifier.fillMaxWidth()
            ) {
                Branding()
            }


        }
    }
}

@Composable
private fun Branding(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 76.dp)
        )
        Text(
            text = stringResource(id = R.string.app_tagline),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )
        TextFieldSample()
        ButtonExample(onClick = {})
    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier,
    lightTheme: Boolean = LocalContentColor.current.luminance() < 0.5f,
) {
    val assetId = if (lightTheme) {
        R.drawable.ic_notifications_black_24dp
    } else {
        R.drawable.ic_notifications_black_24dp
    }
    Image(
        painter = painterResource(id = assetId),
        modifier = modifier,
        contentDescription = null
    )
}


@Preview(name = "Welcome light theme", uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Welcome dark theme", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ScreenOnePreview() {
    val navController: NavHostController = rememberNavController()
    JetPackComposeWidgetsTheme {
        ScreenOne(navController)
    }
}

@Composable
fun TextFieldSample() {
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("reached screen One") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onNext = {
            if (!focusManager.moveFocus(FocusDirection.Down))
                focusManager.clearFocus()
        }),
        singleLine = true
    )
}

@Composable
fun ButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Screen 1")
    }
    Button(onClick = { onClick() }) {
        Text("Screen 2")
    }
    Button(onClick = { onClick() }) {
        Text("Screen 3")
    }
}
