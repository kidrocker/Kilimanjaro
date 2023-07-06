package com.dvt.kilimanjaro.ui.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dvt.domain.model.Favorite
import com.dvt.kilimanjaro.R
import com.dvt.uicomponents.theme.Green700
import com.dvt.uicomponents.theme.KilimanjaroTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun FavoritesScreen(
     navigator: DestinationsNavigator,
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState is FavoritesViewModel.UIState.FavoriteData) {
        FavoritesContent(
            favorites = (uiState as FavoritesViewModel.UIState.FavoriteData).favorites
        ) {
            viewModel.setNewFavorite(it, navigator)
        }
    } else {
        EmptyScreen()
    }
}

@Composable
fun EmptyScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "We could not find any favorites cities saved",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun FavoritesContent(
    favorites: List<Favorite>,
    onItemClicked: (favorite: Favorite) -> Unit
) {
    Column {
        TopAppBar(backgroundColor = Green700) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Light,
                color = Color.White
            )

        }
        LazyColumn {
            items(favorites) { fav ->
                Column(modifier = Modifier.clickable {
                    onItemClicked(fav)
                }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_favorite_border_24),
                            contentDescription = ""
                        )

                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = fav.name,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Light,
                        )
                    }
                    Divider(color = Color.LightGray, modifier = Modifier.padding(horizontal = 8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesPreview() {
    KilimanjaroTheme {
        //FavoritesScreen()
    }
}

