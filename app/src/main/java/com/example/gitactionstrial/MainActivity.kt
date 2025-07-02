package com.example.gitactionstrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gitactionstrial.ui.theme.GitActionsTrialTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitActionsTrialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserForm(modifier = Modifier.padding(innerPadding))
                }
            }
        }

    }
}







@Composable
fun UserForm(
    modifier: Modifier = Modifier,
    viewModel: UserFormViewModel = viewModel()
) {
    val state by viewModel.userData.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = state.name,
            onValueChange = viewModel::updateName,
            label = { Text("Enter your name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.age,
            onValueChange = viewModel::updateAge,
            label = { Text("Enter your age") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { viewModel.submit() }) {
            Text("Submit")
        }

        if (state.submitted) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Hello ${state.name}, you are ${state.age} years old!")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GitActionsTrialTheme {
        UserForm(modifier = Modifier.padding(10.dp))
    }
}