package com.example.countticker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.model.CountState
import com.example.myapplication.data.model.CountViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountTickerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountTickerApp()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun CountTickerApp() {
        val viewModel: CountViewModel.CountViewModel = viewModel()
        val countState by viewModel.countState.collectAsState()

        Scaffold(
            topBar = { AppBar() },
            content = { Content(countState, viewModel) }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppBar() {
        TopAppBar(
            title = { Text(text = "Count Ticker App") }
        )
    }

    @Composable
    fun Content(countState: CountState, viewModel: CountViewModel.CountViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Count: ${countState.count}", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { viewModel.incrementCount() }) {
                    Text(text = "Increment")
                }

                Button(onClick = { viewModel.decrementCount() }) {
                    Text(text = "Decrement")
                }

                Button(onClick = { viewModel.resetCount() }) {
                    Text(text = "Reset")
                }
            }
        }
    }

    @Composable
    fun CountTickerAppTheme(function: () -> Unit) {
        MaterialTheme {
            CountTickerApp()
        }
    }

    @Composable
    fun MyApp() {
        CountTickerAppTheme {
            CountTickerApp()
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CountTickerAppTheme {
            CountTickerApp()
        }
    }

}


