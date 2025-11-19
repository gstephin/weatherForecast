package com.machinetest.ui.theme.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.machinetest.domain.model.ForecastData

/**
 * HomeScreen
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(viewModel: ForecastViewModel) {


    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.getForecast()
    }

    Scaffold() {


        Box(modifier = Modifier.fillMaxSize()) {


            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                when (uiState) {
                    is ForecastUiState.Idle -> {
                        Text(text = "Idle State")
                    }

                    is ForecastUiState.Loading -> {
                        Text("Loading...")
                    }

                    is ForecastUiState.Success -> {
                        ForecastSuccessView(
                            data = (uiState as ForecastUiState.Success).forecast,
                        )
                    }

                    is ForecastUiState.Error -> {
                        Text("error")
                    }
                }

            }
        }

    }
}

@Composable
fun ForecastSuccessView(data: List<ForecastData>) {

    LazyColumn {

        items(data) { forcast ->
            Card(forcast)
        }

    }
}

@Composable
fun Card(forcast: ForecastData) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 24.dp)) {
        Text(text = "Date: ${forcast.timeStamp}, Temp: ${forcast.temperature}, Condition: ${forcast.condition}")
    }

}