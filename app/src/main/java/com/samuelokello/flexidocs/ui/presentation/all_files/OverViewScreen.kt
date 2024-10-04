package com.samuelokello.flexidocs.ui.presentation.all_files

import android.os.Environment
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun OverViewScreen(modifier: Modifier = Modifier) {
    var tabIndex by rememberSaveable { mutableStateOf(0) }
    val tabs = listOf("All", "PDF", "Word", "Excel", "PPT")

    Column {
        TabRow(
            selectedTabIndex = tabIndex
        ) {
            tabs.onEachIndexed {index, title ->
                Tab(
                    text = { Text(text = title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> OverViewScreenContent()
            1 -> PdfFilesScreen()
            2 -> WordFilesScreen()
            3 -> ExcelFilesScreen()
            4 -> PptFilesScreen()
        }
    }

}
@Composable
fun OverViewScreenContent() {

    val context = LocalContext.current
    val pdfFiles = remember { mutableStateOf(listOf<String>()) }

    LaunchedEffect(Unit) {
        val storageDirs = listOfNotNull(
            context.getExternalFilesDir(null),
            context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
            context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
            context.getExternalFilesDir(Environment.DIRECTORY_MUSIC),
        )

        val pdfList = storageDirs.flatMap { dir ->
            dir.listFiles { file -> file.extension == "pdf" }?.map { it.name } ?: emptyList()
        }

        Log.d("AllFilesScreen", "PDF files found: $pdfList")
        pdfFiles.value = pdfList
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (pdfFiles.value.isEmpty()) {
            Text(text = "No PDF files found")
        } else {
            Column {
                pdfFiles.value.forEach { fileName ->
                    Text(text = fileName)
                }
            }
        }
    }
}

@Composable
fun PdfFilesScreen(modifier: Modifier = Modifier) {
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "PDF Files")
    }

}

@Composable
fun WordFilesScreen(modifier: Modifier = Modifier) {
    Column (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Word Files")
    }
}

@Composable
fun ExcelFilesScreen(modifier: Modifier = Modifier) {
    Column (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Excel Files")
    }
}

@Composable
fun PptFilesScreen(modifier: Modifier = Modifier) {
    Column (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Power Point Files")
    }
}