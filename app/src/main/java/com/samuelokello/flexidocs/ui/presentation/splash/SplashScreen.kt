package com.samuelokello.flexidocs.ui.presentation.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuelokello.flexidocs.R

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit
) {
    var progress by remember { mutableFloatStateOf(0f) }

    DisposableEffect(Unit) {
        val totalDuration = 2000L // 2 seconds
        val interval = 50L // Update interval in milliseconds
        val steps = totalDuration / interval

        val job = CoroutineScope(Dispatchers.Main).launch {
            for (i in 1..steps) {
                delay(interval)
                progress = i / steps.toFloat()
            }
            navigateToHome()
        }

        onDispose {
            job.cancel()
        }
    }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.flexidocs_logo),
                modifier = Modifier.size(200.dp),
                contentDescription = "FlexiDocs Logo",
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "All File Reader",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .padding(horizontal = 32.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashPrev() {
    SplashScreen(navigateToHome = {})
}
