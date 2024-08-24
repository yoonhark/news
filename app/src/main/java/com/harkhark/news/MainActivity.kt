package com.harkhark.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.harkhark.core.common.network.util.NetworkMonitor
import com.harkhark.core.designsystem.AppTheme
import com.harkhark.news.ui.NewsApp
import com.harkhark.news.ui.rememberAppState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val appState = rememberAppState(
                        networkMonitor = networkMonitor,
                    )
                    Box(modifier = Modifier.fillMaxSize()) {
                        NewsApp(
                            appState,
                        )
                    }
                }
            }
        }
    }
}
