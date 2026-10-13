package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.*

data class ProfileData(
    val id: String,
    val name: String,
    val color: Color,
    val isKids: Boolean = false
)

@Composable
fun ProfilePickerScreen(
    onProfileSelected: (ProfileData) -> Unit,
    modifier: Modifier = Modifier,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var isEditing by remember { mutableStateOf(false) }

    val profiles = listOf(
        ProfileData("p1", "Prem", Color(0xFFE50914)),
        ProfileData("p2", "Family", Color(0xFF0071EB)),
        ProfileData("p3", "Guest", Color(0xFF2E7D32)),
        ProfileData("p4", "Kids", Color(0xFFFF9800), isKids = true)
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        when (screenState) {
            ScreenLoadingState.Loading -> {
                ProfilePickerShimmer()
            }
            ScreenLoadingState.Empty -> {
                EmptyStateView(
                    title = "No Profiles Found",
                    message = "Add a profile to start watching Netflix.",
                    icon = Icons.Default.Person,
                    actionLabel = "Add Profile",
                    onAction = { screenState = ScreenLoadingState.Content }
                )
            }
            ScreenLoadingState.Error -> {
                ErrorStateView(
                    title = "Couldn't load profiles",
                    message = "We could not load your user profiles right now.",
                    onRetry = { screenState = ScreenLoadingState.Content }
                )
            }
            ScreenLoadingState.Content -> {
                // Edit Button in Top Right (48dp Touch Target)
                IconButton(
                    onClick = { isEditing = !isEditing },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = if (isEditing) "Done managing profiles" else "Manage Profiles",
                        tint = if (isEditing) Color(0xFFE50914) else Color.White
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (isEditing) "Manage Profiles" else "Who's Watching?",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(36.dp))

                    // 2x2 Grid of Profiles
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier.width(260.dp)
                    ) {
                        items(profiles) { profile ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                                    .clickable {
                                        if (!isEditing) onProfileSelected(profile)
                                    }
                                    .semantics {
                                        contentDescription = "Profile for ${profile.name}${if (profile.isKids) ", Kids profile" else ""}"
                                    }
                            ) {
                                HawkinsAvatar(
                                    name = profile.name,
                                    size = HawkinsAvatarSize.ExtraLarge,
                                    shape = HawkinsAvatarShape.Square,
                                    avatarColor = profile.color,
                                    showEditBadge = isEditing
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = profile.name,
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Shimmer skeleton layout for Profile Picker Screen.
 */
@Composable
fun ProfilePickerShimmer() {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ShimmerBox(modifier = Modifier.width(180.dp).height(28.dp))
        Spacer(modifier = Modifier.height(36.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            ShimmerBox(modifier = Modifier.size(96.dp).clip(RoundedCornerShape(8.dp)))
            ShimmerBox(modifier = Modifier.size(96.dp).clip(RoundedCornerShape(8.dp)))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            ShimmerBox(modifier = Modifier.size(96.dp).clip(RoundedCornerShape(8.dp)))
            ShimmerBox(modifier = Modifier.size(96.dp).clip(RoundedCornerShape(8.dp)))
        }
    }
}

