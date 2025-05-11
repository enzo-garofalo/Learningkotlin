package com.time2.learningui_ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.time2.learningui_ux.components.buildBottomBar
import com.time2.learningui_ux.components.buildBottomModal
import com.time2.learningui_ux.components.buildCategoryHeader
import com.time2.learningui_ux.components.buildTopAppBar
import com.time2.learningui_ux.components.buildFloatingActionButton
import com.time2.learningui_ux.components.buildPasswordManager
import com.time2.learningui_ux.components.showCategoryElements
import com.time2.learningui_ux.components.showPasswordList
import com.time2.learningui_ux.ui.theme.LearningUIUXTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningUIUXTheme(dynamicColor = false) {

                var showModal by remember { mutableStateOf(false) }
                val sheetState = rememberModalBottomSheetState()

                Scaffold(
                    topBar = {
                        buildTopAppBar(
                            userName = "JoãoGabriel",
                            showBackClick =  true,
                            onBackClick   =  { /*TODO*/},
                            onLogoutClick =  { /*TODO*/},
                        )
                    },
                    bottomBar = {
                        buildBottomBar()
                    },
                    floatingActionButton = {
                        buildFloatingActionButton(
                            onClick = { showModal = true }
                        )
                    }
                ) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        // Conteúdo principal da tela
                        buildCategoryHeader(
                            onSettingsClick = {/*TODO*/}
                        )

                        showCategoryElements()

                        buildPasswordManager(
                            onAllFilterClick = {/*TODO*/},
                            onRecentClick    = {/*TODO*/}
                        )

                        showPasswordList()
                    }

                    if (showModal) {
                        buildBottomModal(
                            onDismiss = { showModal = false },
                            sheetState = sheetState
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(modifier: Modifier = Modifier) {
    LearningUIUXTheme {
        Greeting("Android")
    }
}
