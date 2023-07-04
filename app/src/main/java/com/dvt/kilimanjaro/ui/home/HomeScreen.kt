package com.dvt.kilimanjaro.ui.home

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvt.kilimanjaro.R
import com.dvt.uicomponents.theme.KilimanjaroTheme
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun HomeScreen(

) {

    HomeScreenContent()
}

@Composable
fun HomeScreenContent(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primaryVariant)
    ) {

        Box(modifier = Modifier.weight(1f)) {

            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.mipmap.forest_sunny),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )

            Text(
                text = "18c",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                style = MaterialTheme.typography.h1
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                Text(
                    text = "18c",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = "min",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )


            }
            Column {
                Text(
                    text = "18c",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = "current",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )


            }
            Column {
                Text(
                    text = "18c",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = "max",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )
            }
        }

        Divider(color = Color.White, modifier = Modifier.padding(top = 4.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            //items(items = )

        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KilimanjaroTheme {
        HomeScreen()
    }
}