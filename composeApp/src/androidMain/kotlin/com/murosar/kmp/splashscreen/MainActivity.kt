package com.murosar.kmp.splashscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Simple example, but we can depend on any more complex validation like checking session
        var isCheckingSomething = true
        lifecycleScope.launch {
            delay(3000L)
            isCheckingSomething = false
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                // Here we can configure the splash time.
                // It will be on screen until we return a false
                isCheckingSomething
            }
        }
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}