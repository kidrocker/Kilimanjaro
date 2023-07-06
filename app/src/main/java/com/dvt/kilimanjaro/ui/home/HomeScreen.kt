package com.dvt.kilimanjaro.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dvt.kilimanjaro.R
import com.dvt.uicomponents.components.CustomProgress
import com.dvt.uicomponents.theme.KilimanjaroTheme
import com.ramcosta.composedestinations.annotation.Destination
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.dvt.domain.model.Day
import com.dvt.domain.model.Favorite
import com.dvt.domain.model.Weather
import com.dvt.kilimanjaro.ui.destinations.FavoritesScreenDestination
import com.dvt.uicomponents.theme.colorCloudy
import com.dvt.uicomponents.theme.colorRainy
import com.dvt.uicomponents.theme.colorSunny
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UIState.WeatherData -> HomeScreenContent(
            navigator = navigator,
            favorite = (uiState as UIState.WeatherData).favorite,
            current = (uiState as UIState.WeatherData).current,
            fiveDay = (uiState as UIState.WeatherData).lastFive
        )

        is UIState.Loading -> LoadingScreen()
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CustomProgress(contentDesc = stringResource(id = R.string.loading))
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun HomeScreenContent(
    navigator: DestinationsNavigator,
    favorite: Favorite,
    current: Weather?,
    fiveDay: List<Day>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                when (current?.main) {
                    "Clouds" -> colorCloudy
                    "Rain" -> colorRainy
                    else -> colorSunny
                }
            )
    ) {


        Box(modifier = Modifier.weight(1f)) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(
                    id = when (current?.main) {
                        "Clouds" -> R.mipmap.forest_cloudy
                        "Rain" -> R.mipmap.forest_rainy
                        else -> R.mipmap.forest_sunny
                    }
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            TopAppBar(
                elevation = 0.dp,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth(),
                backgroundColor = Color.Transparent,
                title = { Text(text = favorite.name, color = Color.White) },
                navigationIcon =
                {
                    IconButton(onClick = {
                        navigator.navigate(FavoritesScreenDestination)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.round_menu_24),
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }
                })

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedContent(
                    targetState = current?.current,
                    transitionSpec = {
                        slideInVertically { it } with slideOutVertically { -it }
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.degrees, current?.current ?: 0),
                        color = Color.White,
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = current?.main ?: "",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.degrees, current?.min ?: 0),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.min),
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.degrees, current?.current ?: 0),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.current),
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )


            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.degrees, current?.max ?: 0),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.max),
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }

        Divider(color = Color.White, modifier = Modifier.padding(top = 4.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(fiveDay) { item ->
                Row(
                    modifier = Modifier
                        .animateItemPlacement()
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 12.dp, end = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = item.day,
                        style = MaterialTheme.typography.h6,
                        color = Color.LightGray,
                        modifier = Modifier.weight(1f)
                    )

                    Image(
                        painter = painterResource(
                            id = when (item.weather) {
                                "Clouds" -> R.mipmap.partlysunny
                                "Rain" -> R.mipmap.rain
                                else -> R.mipmap.clear
                            }
                        ),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.degrees, item.degrees),
                        style = MaterialTheme.typography.h6,
                        color = Color.LightGray,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Right
                    )


                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KilimanjaroTheme {
        //HomeScreen()
    }
}