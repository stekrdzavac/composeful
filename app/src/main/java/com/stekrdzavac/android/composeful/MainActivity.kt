package com.stekrdzavac.android.composeful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.stekrdzavac.android.composeful.button.ProgressButton
import com.stekrdzavac.android.composeful.ui.theme.ComposefulTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposefulTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
) {
    var loading1 by remember { mutableStateOf(false) }
    var loading2 by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier
        .fillMaxWidth()){

        ProgressButton(
            onButtonClick = {
                loading1 = !loading1
                coroutineScope.launch {
                    delay(3000)
                    loading1 = !loading1
                }
            },
            loading = loading1,
            modifier = Modifier.fillMaxWidth().padding(8.dp).align(CenterHorizontally)
        ) {
            Icon(
                imageVector = Icons.Default.PlayCircle,
                contentDescription = "Play Button",
                modifier = Modifier.size(88.dp)
            )
        }

        Divider(modifier = Modifier.height(4.dp))

        ProgressButton(
            onButtonClick = {
                loading2 = !loading2
                coroutineScope.launch {
                    delay(3000)
                    loading2 = !loading2
                }
            },
            buttonText = name,
            loading = loading2,
            modifier = Modifier
                .wrapContentSize()
                .align(CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposefulTheme {
        Greeting("Android")
    }
}