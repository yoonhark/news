package com.harkhark.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.ui.annotation.DevicePreviews

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickItem: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isKr by viewModel.isKr.collectAsState()
    HomeScreenView(isKr, uiState, viewModel::setNewsSource, onClickItem)
}

@Composable
private fun HomeScreenView(
    isKr: Boolean,
    state: NewsUiState,
    onToggle: (Boolean) -> Unit = {},
    onClickItem: (String) -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val gridColumns = if (configuration.screenWidthDp > 600) 3 else 1
    Column {
        SourceRadioView(isKr, onToggle)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is NewsUiState.Loading -> {
                    Text(text = "News Loading...")
                }

                is NewsUiState.Success -> {
                    val newsList = state.news

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(gridColumns),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(newsList) { news ->
                            NewsItem(news = news, onClickItem)
                        }
                    }
                }

                is NewsUiState.Error -> {
                    Text(text = "Failed to load news.")
                }
            }
        }
    }
}

@Composable
private fun SourceRadioView(isKr: Boolean, onToggle: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Korea RadioButton with Text
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = isKr,
                onClick = { onToggle(true) }
            )
            Text(text = "Korea", style = MaterialTheme.typography.labelLarge)
        }

        // BBC RadioButton with Text
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = !isKr,
                onClick = { onToggle(false) }
            )
            Text(text = "BBC", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
private fun NewsItem(news: NewsData, onClickItem: (String) -> Unit) {
    Box(modifier = Modifier
        .padding(8.dp)
        .clickable {
            news.isRead = true
            onClickItem(news.url)
        }) {
        Row {
            ThumbnailImage(url = news.urlToImage, modifier = Modifier.size(100.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = news.title,
                    color = if (news.isRead) Color.Red else Color.Unspecified,
                    modifier = Modifier.padding(top = 8.dp),
                    maxLines = 3,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = news.publishedAt,
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Composable
private fun ThumbnailImage(
    url: String,
    modifier: Modifier = Modifier
) {
    val painter = if (url.isNotEmpty()) {
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .networkCachePolicy(CachePolicy.READ_ONLY)
                .build()
        )
    } else {
        painterResource(id = R.drawable.no_image)
    }

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
    )
}

@DevicePreviews
@Composable
private fun HomScreenPreview() {
    val sampleNewsList = mutableListOf<NewsData>()

    repeat(10) {
        sampleNewsList.add(sampleNews)
    }

    HomeScreenView(
        isKr = true,
        state = NewsUiState.Success(sampleNewsList)
    )
}


@Preview
@Composable
private fun NewsItemPreview() {
    NewsItem(
        news = sampleNews,
        onClickItem = {}
    )
}

private val sampleNews = NewsData(
    title = "가장 강력한 화이트, 조텍 탁탁몰 RTX 4080 SUPER 깜짝 주말 특가 진행 - 위클리포스트",
    urlToImage = "",
    publishedAt = "2024-08-23 9:45",
    url = "",
    isRead = false,
)