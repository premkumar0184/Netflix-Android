package com.recreated.netflix.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.EmptyStateView
import com.recreated.netflix.components.ErrorStateView
import com.recreated.netflix.components.ScreenLoadingState
import com.recreated.netflix.components.ShimmerBox
import com.recreated.netflix.theme.NetflixRed

@Composable
fun PlayerScreen(
    title: String = "Stranger Things",
    episodeTitle: String = "S4:E1 Chapter One: The Hellfire Club",
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var isPlaying by remember { mutableStateOf(true) }
    var areControlsVisible by remember { mutableStateOf(true) }
    var currentProgress by remember { mutableFloatStateOf(0.35f) }
    var playbackSpeed by remember { mutableStateOf("1.0x") }
    var isLocked by remember { mutableStateOf(false) }

    when (screenState) {
        ScreenLoadingState.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .navigationBarsPadding(),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = onCloseClick,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .statusBarsPadding()
                        .padding(16.dp)
                        .size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(
                        color = NetflixRed,
                        modifier = Modifier.size(54.dp),
                        strokeWidth = 4.dp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Buffering stream...",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
        ScreenLoadingState.Empty -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .navigationBarsPadding()
            ) {
                IconButton(
                    onClick = onCloseClick,
                    modifier = Modifier.align(Alignment.TopStart).statusBarsPadding().padding(16.dp).size(48.dp)
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                EmptyStateView(
                    title = "Playback Unavailable",
                    message = "The video stream for this episode could not be initialized.",
                    actionLabel = "Back to Details",
                    onAction = onCloseClick
                )
            }
        }
        ScreenLoadingState.Error -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .navigationBarsPadding()
            ) {
                IconButton(
                    onClick = onCloseClick,
                    modifier = Modifier.align(Alignment.TopStart).statusBarsPadding().padding(16.dp).size(48.dp)
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                ErrorStateView(
                    title = "Playback Error",
                    message = "We're experiencing playback issues. Please retry or pick another title.",
                    onRetry = { screenState = ScreenLoadingState.Content }
                )
            }
        }
        ScreenLoadingState.Content -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        areControlsVisible = !areControlsVisible
                    }
            ) {
                // Video Surface
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF0A0A0A)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1080p Ultra HD • Dolby Atmos Stream",
                        color = Color.White.copy(alpha = 0.25f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Animated Player Controls Overlay
                AnimatedVisibility(
                    visible = areControlsVisible,
                    enter = fadeIn(),
                    exit = fadeOut(),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.65f))
                    ) {
                        // Top App Bar
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .statusBarsPadding()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = onCloseClick,
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = title,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = episodeTitle,
                                    color = Color.LightGray,
                                    fontSize = 12.sp
                                )
                            }

                            IconButton(
                                onClick = {},
                                enabled = !isLocked,
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Subtitles,
                                    contentDescription = "Audio & Subtitles",
                                    tint = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f)
                                )
                            }

                            IconButton(
                                onClick = { isLocked = !isLocked },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = if (isLocked) Icons.Default.Lock else Icons.Default.LockOpen,
                                    contentDescription = if (isLocked) "Unlock Controls" else "Lock Controls",
                                    tint = if (isLocked) NetflixRed else Color.White
                                )
                            }
                        }

                        // Center Controls: Replay 10s, Play/Pause, Forward 10s
                        Row(
                            modifier = Modifier.align(Alignment.Center),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(40.dp)
                        ) {
                            IconButton(
                                onClick = {
                                    currentProgress = (currentProgress - 0.05f).coerceAtLeast(0f)
                                },
                                enabled = !isLocked,
                                modifier = Modifier.size(56.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Replay10,
                                    contentDescription = "Replay 10 Seconds",
                                    tint = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                    modifier = Modifier.size(42.dp)
                                )
                            }

                            IconButton(
                                onClick = { isPlaying = !isPlaying },
                                enabled = !isLocked,
                                modifier = Modifier.size(80.dp)
                            ) {
                                Icon(
                                    imageVector = if (isPlaying) Icons.Default.PauseCircleFilled else Icons.Default.PlayCircleFilled,
                                    contentDescription = if (isPlaying) "Pause" else "Play",
                                    tint = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                    modifier = Modifier.size(76.dp)
                                )
                            }

                            IconButton(
                                onClick = {
                                    currentProgress = (currentProgress + 0.05f).coerceAtMost(1f)
                                },
                                enabled = !isLocked,
                                modifier = Modifier.size(56.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Forward10,
                                    contentDescription = "Forward 10 Seconds",
                                    tint = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                    modifier = Modifier.size(42.dp)
                                )
                            }
                        }

                        // Bottom Timeline Scrubber & Actions
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .navigationBarsPadding()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            // Scrubber Slider
                            Slider(
                                value = currentProgress,
                                onValueChange = { currentProgress = it },
                                enabled = !isLocked,
                                modifier = Modifier.fillMaxWidth(),
                                colors = SliderDefaults.colors(
                                    thumbColor = NetflixRed,
                                    activeTrackColor = NetflixRed,
                                    inactiveTrackColor = Color.White.copy(alpha = 0.35f),
                                    disabledThumbColor = NetflixRed.copy(alpha = 0.5f),
                                    disabledActiveTrackColor = NetflixRed.copy(alpha = 0.5f)
                                )
                            )

                            // Timestamps Row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "23:45", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                                Text(text = "-42:15", color = Color.LightGray, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            // Player Action Buttons Row (48dp Touch Targets)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextButton(
                                    onClick = {
                                        playbackSpeed = when (playbackSpeed) {
                                            "1.0x" -> "1.25x"
                                            "1.25x" -> "1.5x"
                                            "1.5x" -> "0.75x"
                                            else -> "1.0x"
                                        }
                                    },
                                    enabled = !isLocked,
                                    modifier = Modifier.defaultMinSize(minHeight = 48.dp)
                                ) {
                                    Text(
                                        text = "Speed ($playbackSpeed)",
                                        color = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                TextButton(
                                    onClick = { isLocked = !isLocked },
                                    modifier = Modifier.defaultMinSize(minHeight = 48.dp)
                                ) {
                                    Icon(
                                        imageVector = if (isLocked) Icons.Default.LockOpen else Icons.Default.Lock,
                                        contentDescription = if (isLocked) "Unlock Controls" else "Lock Controls",
                                        tint = if (isLocked) NetflixRed else Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isLocked) "Unlock" else "Lock",
                                        color = if (isLocked) NetflixRed else Color.White,
                                        fontSize = 13.sp
                                    )
                                }

                                TextButton(
                                    onClick = {},
                                    enabled = !isLocked,
                                    modifier = Modifier.defaultMinSize(minHeight = 48.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VideoLibrary,
                                        contentDescription = null,
                                        tint = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Episodes",
                                        color = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                        fontSize = 13.sp
                                    )
                                }

                                TextButton(
                                    onClick = {},
                                    enabled = !isLocked,
                                    modifier = Modifier.defaultMinSize(minHeight = 48.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.SkipNext,
                                        contentDescription = null,
                                        tint = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Next Ep",
                                        color = if (!isLocked) Color.White else Color.White.copy(alpha = 0.38f),
                                        fontSize = 13.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

