package com.rivibi.venoe.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rivibi.venoe.R
import com.rivibi.venoe.ui.theme.VenoeTheme

@Composable
fun EventItem(
    modifier: Modifier = Modifier,
    name: String,
    description: String,
    bannerUrl: String? = null,
    startTime: String,
    endTime: String,
    location: String,
) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .aspectRatio(1 / 1f)
                .background(color = Color.LightGray)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = bannerUrl ?: R.drawable.no_image_placeholder
                ),
                contentDescription = stringResource(
                    R.string.content_description_event_banner
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .aspectRatio(1 / 1f)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp, bottom = 12.dp)
            ) {
                Text(
                    text = startTime,
                    style = MaterialTheme.typography.titleMedium
                        .copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = endTime,
                    style = MaterialTheme.typography.titleMedium
                        .copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                        .copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = stringResource(R.string.content_description_location_icon)
                    )
                    Text(
                        text = location,
                        style = MaterialTheme.typography.bodyMedium
                            .copy(fontWeight = FontWeight.Bold),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun EventItemPreview() {
    VenoeTheme {
        EventItem(
            name = "Ruang Gerak",
            description = "Ini adalah event di mana semua orang bergerak di dalam ruangan. Event ini diadakan di sebuah kota besar di Jawa Timur.",
            startTime = "20 Juni 2023, 8.30AM",
            endTime = "20 Juni 2023, 2.30PM",
            location = "Swiss Belinn Malang, Kota Malang, Jawa Timur"
        )
    }
}