package com.recreated.netflix.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import coil.compose.SubcomposeAsyncImage
import com.recreated.netflix.theme.NetflixRed

data class MediaItem(
    val id: String,
    val title: String,
    val imageUrl: String? = null,
    val backdropUrl: String? = null,
    val isTop10: Boolean = false,
    val rank: Int? = null,
    val progress: Float? = null,
    val episodeLabel: String? = null,
    val genres: List<String> = emptyList(),
    val matchPercentage: Int = 98,
    val maturityRating: String = "16+",
    val releaseYear: String = "2023",
    val durationOrSeasons: String = "1 Season",
    val synopsis: String = "A compelling Netflix original story with intense drama, suspenseful twists, and acclaimed performances.",
    val starring: String = "Netflix Ensemble Cast"
)

val NetflixMediaCatalog: Map<String, MediaItem> = mapOf(
    "1" to MediaItem(
        id = "1",
        title = "Stranger Things",
        genres = listOf("Sci-Fi", "Suspenseful", "Nostalgic", "80s"),
        isTop10 = true,
        rank = 1,
        progress = 0.65f,
        episodeLabel = "S4:E1 Chapter One",
        releaseYear = "2022",
        durationOrSeasons = "4 Seasons",
        synopsis = "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces and one strange little girl.",
        starring = "Winona Ryder, David Harbour, Millie Bobby Brown"
    ),
    "2" to MediaItem(
        id = "2",
        title = "Squid Game",
        genres = listOf("Thriller", "Drama", "Suspenseful"),
        isTop10 = true,
        rank = 2,
        progress = 0.30f,
        episodeLabel = "S1:E3 The Man with the Umbrella",
        releaseYear = "2021",
        durationOrSeasons = "1 Season",
        maturityRating = "18+",
        synopsis = "Hundreds of cash-strapped players accept a strange invitation to compete in children's games with deadly high stakes.",
        starring = "Lee Jung-jae, Park Hae-soo, Wi Ha-jun"
    ),
    "3" to MediaItem(
        id = "3",
        title = "Wednesday",
        genres = listOf("Fantasy", "Comedy", "Mystery"),
        isTop10 = true,
        rank = 3,
        progress = 0.85f,
        episodeLabel = "S1:E4 Woe What a Night",
        releaseYear = "2022",
        durationOrSeasons = "1 Season",
        maturityRating = "13+",
        synopsis = "Smart, sarcastic and a little dead inside, Wednesday Addams investigates a murder spree while making new friends — and foes — at Nevermore Academy.",
        starring = "Jenna Ortega, Gwendoline Christie, Riki Lindhome"
    ),
    "4" to MediaItem(
        id = "4",
        title = "Bridgerton",
        genres = listOf("Romance", "Period Drama", "Steamy"),
        isTop10 = true,
        rank = 4,
        releaseYear = "2024",
        durationOrSeasons = "3 Seasons",
        maturityRating = "18+",
        synopsis = "The eight close-knit siblings of the Bridgerton family look for love and happiness in London high society.",
        starring = "Nicola Coughlan, Luke Newton, Jonathan Bailey"
    ),
    "5" to MediaItem(
        id = "5",
        title = "The Witcher",
        genres = listOf("Action", "Fantasy", "Monsters"),
        isTop10 = true,
        rank = 5,
        releaseYear = "2023",
        durationOrSeasons = "3 Seasons",
        maturityRating = "18+",
        synopsis = "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts.",
        starring = "Henry Cavill, Anya Chalotra, Freya Allan"
    ),
    "6" to MediaItem(
        id = "6",
        title = "Red Notice",
        genres = listOf("Action", "Comedy", "Heist"),
        isTop10 = true,
        rank = 6,
        releaseYear = "2021",
        durationOrSeasons = "1h 58m",
        maturityRating = "13+",
        synopsis = "An FBI profiler pursuing the world's most wanted art thief becomes his reluctant partner in crime to catch an elusive crook who's always one step ahead.",
        starring = "Dwayne Johnson, Ryan Reynolds, Gal Gadot"
    ),
    "7" to MediaItem(
        id = "7",
        title = "Glass Onion",
        genres = listOf("Mystery", "Comedy", "Whodunit"),
        isTop10 = true,
        rank = 7,
        releaseYear = "2022",
        durationOrSeasons = "2h 19m",
        maturityRating = "13+",
        synopsis = "Famed tech billionaire Miles Bron invites his friends for a getaway on his private Greek island, but when someone turns up dead, Detective Benoit Blanc is put on the case.",
        starring = "Daniel Craig, Edward Norton, Janelle Monáe"
    ),
    "8" to MediaItem(
        id = "8",
        title = "The Gray Man",
        genres = listOf("Action", "Spy Thriller", "Explosive"),
        isTop10 = true,
        rank = 8,
        releaseYear = "2022",
        durationOrSeasons = "2h 9m",
        maturityRating = "16+",
        synopsis = "When the CIA's most skilled operative accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt.",
        starring = "Ryan Gosling, Chris Evans, Ana de Armas"
    ),
    "9" to MediaItem(
        id = "9",
        title = "Extraction 2",
        genres = listOf("Action", "Adrenaline", "Gritty"),
        releaseYear = "2023",
        durationOrSeasons = "2h 3m",
        maturityRating = "18+",
        synopsis = "Back from the brink of death, highly skilled commando Tyler Rake embarks on another dangerous mission to save the imprisoned family of a ruthless gangster.",
        starring = "Chris Hemsworth, Golshifteh Farahani, Adam Bessa"
    ),
    "10" to MediaItem(
        id = "10",
        title = "Leave the World Behind",
        genres = listOf("Thriller", "Suspenseful", "Mystery"),
        releaseYear = "2023",
        durationOrSeasons = "2h 21m",
        maturityRating = "18+",
        synopsis = "A family's quiet vacation is upended when two strangers arrive at night, bearing news of a mysterious cyberattack and seeking refuge.",
        starring = "Julia Roberts, Mahershala Ali, Ethan Hawke"
    ),
    "11" to MediaItem(
        id = "11",
        title = "Enola Holmes",
        genres = listOf("Mystery", "Adventure", "Witty"),
        releaseYear = "2020",
        durationOrSeasons = "2h 3m",
        maturityRating = "13+",
        synopsis = "While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord.",
        starring = "Millie Bobby Brown, Henry Cavill, Sam Claflin"
    ),
    "12" to MediaItem(
        id = "12",
        title = "Cyberpunk: Edgerunners",
        genres = listOf("Anime", "Sci-Fi", "Cyberpunk"),
        releaseYear = "2022",
        durationOrSeasons = "1 Season",
        maturityRating = "18+",
        synopsis = "A street kid trying to survive in a technology and body modification-obsessed city of the future decides to stay alive by becoming an edgerunner.",
        starring = "KENN, Aoi Yuki, Hiroki Touchi"
    ),
    "13" to MediaItem(
        id = "13",
        title = "Arcane",
        genres = listOf("Action", "Sci-Fi", "Steampunk"),
        releaseYear = "2021",
        durationOrSeasons = "1 Season",
        maturityRating = "16+",
        synopsis = "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war between magic technologies and incompatible convictions.",
        starring = "Hailee Steinfeld, Ella Purnell, Kevin Alejandro"
    ),
    "14" to MediaItem(
        id = "14",
        title = "Love, Death & Robots",
        genres = listOf("Animation", "Sci-Fi", "Anthology"),
        releaseYear = "2022",
        durationOrSeasons = "3 Volumes",
        maturityRating = "18+",
        synopsis = "Terrifying creatures, wicked surprises and dark comedy converge in this NSFW anthology of animated stories presented by Tim Miller and David Fincher.",
        starring = "Anthology Ensemble"
    ),
    "15" to MediaItem(
        id = "15",
        title = "Altered Carbon",
        genres = listOf("Sci-Fi", "Cyberpunk", "Dystopian"),
        releaseYear = "2020",
        durationOrSeasons = "2 Seasons",
        maturityRating = "18+",
        synopsis = "More than 300 years in the future, society has been transformed by new technology: consciousness is digitized and human bodies are interchangeable.",
        starring = "Anthony Mackie, Joel Kinnaman, Renée Elise Goldsberry"
    ),
    "nh1" to MediaItem(
        id = "nh1",
        title = "Arcane: Season 2",
        genres = listOf("Steampunk", "Action", "Cyberpunk", "Animation"),
        releaseYear = "2024",
        durationOrSeasons = "Coming Nov 8",
        maturityRating = "16+",
        synopsis = "Jinx and Vi face the consequences of their choices as war erupts between the utopian city of Piltover and the underground city of Zaun.",
        starring = "Hailee Steinfeld, Ella Purnell, Kevin Alejandro"
    ),
    "nh2" to MediaItem(
        id = "nh2",
        title = "Cobra Kai: Season 6",
        genres = listOf("Martial Arts", "Rivalry", "Action", "Comedy"),
        releaseYear = "2024",
        durationOrSeasons = "Coming Nov 15",
        maturityRating = "16+",
        synopsis = "With the global Sekai Taikai tournament approaching, Daniel and Johnny work to rebuild their team amidst fierce international competition.",
        starring = "Ralph Macchio, William Zabka, Xolo Maridueña"
    ),
    "nh3" to MediaItem(
        id = "nh3",
        title = "Squid Game: Season 2",
        genres = listOf("Suspenseful", "Dystopian", "Psychological Thriller"),
        releaseYear = "2024",
        durationOrSeasons = "Coming Dec 26",
        maturityRating = "18+",
        synopsis = "Three years after winning Squid Game, Player 456 gave up going to the states and is back with a new resolution in his mind.",
        starring = "Lee Jung-jae, Lee Byung-hun, Wi Ha-jun"
    ),
    "g1" to MediaItem(
        id = "g1",
        title = "Stranger Things 3: The Game",
        genres = listOf("Action", "Adventure", "Retro"),
        releaseYear = "2023",
        durationOrSeasons = "Mobile Game",
        maturityRating = "12+",
        synopsis = "The official companion game to Season 3 of the hit original series! Play through familiar quests and solve puzzles as your favorite characters.",
        starring = "BonusXP, Netflix Games"
    ),
    "g2" to MediaItem(
        id = "g2",
        title = "Grand Theft Auto: San Andreas",
        genres = listOf("Action", "Open World", "Classic"),
        releaseYear = "2023",
        durationOrSeasons = "Mobile Game",
        maturityRating = "18+",
        synopsis = "Experience the blockbuster classic, updated for mobile with wide-ranging enhancements including brilliant new lighting and environmental upgrades.",
        starring = "Rockstar Games, Netflix Games"
    )
)

fun findMediaItemById(id: String): MediaItem {
    return NetflixMediaCatalog[id] ?: MediaItem(
        id = id,
        title = "Title $id",
        genres = listOf("Drama", "Original"),
        synopsis = "An exciting Netflix story with drama, thrilling twists, and stellar performances."
    )
}

/**
 * High-performance 60fps shimmer brush for skeleton loading placeholders.
 */
@Composable
fun rememberShimmerBrush(): Brush {
    val transition = rememberInfiniteTransition(label = "shimmer_transition")
    val translateAnim by transition.animateFloat(
        initialValue = -800f,
        targetValue = 1600f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1300, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_translation"
    )
    return Brush.linearGradient(
        colors = listOf(
            Color(0xFF161616),
            Color(0xFF262626),
            Color(0xFF383838),
            Color(0xFF262626),
            Color(0xFF161616)
        ),
        start = Offset(translateAnim, translateAnim),
        end = Offset(translateAnim + 500f, translateAnim + 500f)
    )
}

/**
 * Reusable shimmer placeholder box for images and layout skeletons.
 */
@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
    shape: androidx.compose.ui.graphics.Shape = RoundedCornerShape(4.dp)
) {
    val shimmerBrush = rememberShimmerBrush()
    Box(
        modifier = modifier
            .clip(shape)
            .background(shimmerBrush)
    )
}

/**
 * Deterministic, cinematic procedural poster art rendered when offline or without image assets.
 */
@Composable
fun ProceduralPosterArtwork(
    title: String,
    seed: Int = title.hashCode(),
    isLandscape: Boolean = false,
    showTitle: Boolean = true,
    modifier: Modifier = Modifier
) {
    val paletteIndex = kotlin.math.abs(seed) % 5
    val (colorTop, colorMid, colorBottom, accentColor) = when (paletteIndex) {
        0 -> listOf(Color(0xFF3B0B11), Color(0xFF1F060A), Color(0xFF0D0204), Color(0xFFE50914)) // Crimson
        1 -> listOf(Color(0xFF0F2642), Color(0xFF091629), Color(0xFF040A12), Color(0xFF0071EB)) // Midnight Blue
        2 -> listOf(Color(0xFF2A1440), Color(0xFF160A22), Color(0xFF0A0310), Color(0xFF9C27B0)) // Amethyst
        3 -> listOf(Color(0xFF382914), Color(0xFF1E1408), Color(0xFF0D0803), Color(0xFFFF9800)) // Dark Amber
        else -> listOf(Color(0xFF242424), Color(0xFF161616), Color(0xFF0C0C0C), Color(0xFF757575)) // Carbon
    }

    Box(
        modifier = modifier
            .clearAndSetSemantics { }
            .background(
                Brush.verticalGradient(
                    colors = listOf(colorTop, colorMid, colorBottom)
                )
            )
    ) {
        // Subtle decorative canvas accents
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Diagonal light beam / geometric slice
            val path = Path().apply {
                moveTo(0f, height * 0.15f)
                lineTo(width, height * 0.45f)
                lineTo(width, height * 0.65f)
                lineTo(0f, height * 0.35f)
                close()
            }
            drawPath(path, color = accentColor.copy(alpha = 0.08f))

            // Vignette glow at the center
            drawCircle(
                color = accentColor.copy(alpha = 0.15f),
                radius = width * 0.45f,
                center = Offset(width * 0.5f, height * 0.4f)
            )
        }

        // Top Netflix N branding badge
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "N",
                color = NetflixRed,
                fontSize = if (isLandscape) 14.sp else 12.sp,
                fontWeight = FontWeight.Black
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = if (isLandscape) "ORIGINAL" else "SERIES",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 7.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        // Center Monogram / Typographic Artwork
        val monogram = title.split(" ")
            .filter { it.isNotBlank() }
            .take(2)
            .map { it.first().uppercaseChar() }
            .joinToString("")
            .ifEmpty { title.take(2).uppercase() }

        Text(
            text = monogram,
            color = Color.White.copy(alpha = 0.18f),
            fontSize = if (isLandscape) 44.sp else 38.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )

        if (showTitle && title.isNotBlank()) {
            // Bottom Vignette Scrim & Title
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.8f),
                                Color.Black.copy(alpha = 0.95f)
                            )
                        )
                    )
                    .padding(horizontal = 8.dp, vertical = 8.dp)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = if (isLandscape) 13.sp else 11.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = if (isLandscape) 16.sp else 13.sp,
                    style = TextStyle(
                        shadow = Shadow(color = Color.Black, blurRadius = 6f)
                    )
                )
            }
        }
    }
}

/**
 * Resilient async image loading with Coil, smooth shimmer loading, and procedural fallbacks.
 */
@Composable
fun CinematicAsyncImage(
    imageUrl: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    titleFallback: String = "",
    seedFallback: Int = titleFallback.hashCode(),
    aspectRatio: Float = 2f / 3f,
    contentScale: ContentScale = ContentScale.Crop,
    showTitleFallback: Boolean = true
) {
    if (imageUrl.isNullOrBlank()) {
        ProceduralPosterArtwork(
            title = titleFallback,
            seed = seedFallback,
            isLandscape = (aspectRatio > 1.0f),
            showTitle = showTitleFallback,
            modifier = modifier
        )
    } else {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            loading = {
                ShimmerBox(modifier = Modifier.fillMaxSize())
            },
            error = {
                ProceduralPosterArtwork(
                    title = titleFallback,
                    seed = seedFallback,
                    isLandscape = (aspectRatio > 1.0f),
                    showTitle = showTitleFallback,
                    modifier = Modifier.fillMaxSize()
                )
            }
        )
    }
}

@Composable
fun LolomoRow(
    rowTitle: String,
    items: List<MediaItem>,
    onItemClick: (MediaItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = rowTitle,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(items, key = { _, item -> item.id }) { _, item ->
                MovieCard(
                    item = item,
                    onClick = { onItemClick(item) }
                )
            }
        }
    }
}

/**
 * Standard Netflix Movie Card enforcing strict 2:3 portrait poster aspect ratio.
 */
@Composable
fun MovieCard(
    item: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.width(120.dp)
) {
    Box(
        modifier = modifier
            .aspectRatio(2f / 3f) // STRICT 2:3 portrait poster aspect ratio
            .clip(RoundedCornerShape(6.dp))
            .border(BorderStroke(1.dp, Color.White.copy(alpha = 0.08f)), RoundedCornerShape(6.dp))
            .shadow(4.dp, RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .semantics(mergeDescendants = true) {
                contentDescription = "${item.title}, movie poster. Tap to view details."
            }
    ) {
        CinematicAsyncImage(
            imageUrl = item.imageUrl,
            contentDescription = null,
            titleFallback = item.title,
            seedFallback = item.title.hashCode(),
            aspectRatio = 2f / 3f,
            modifier = Modifier.fillMaxSize()
        )

        // Top 10 rank badge if applicable
        if (item.isTop10 && item.rank != null) {
            HawkinsTag(
                text = "TOP 10",
                isTop10 = true,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(5.dp)
            )
        }
    }
}

/**
 * Standard screen presentation states for comprehensive UI state handling.
 */
enum class ScreenLoadingState {
    Loading,
    Content,
    Empty,
    Error
}

/**
 * Reusable empty state view with authentic Hawkins typography and styling.
 */
@Composable
fun EmptyStateView(
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Inbox,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.08f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = NetflixRed,
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB3B3B3),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        if (actionLabel != null && onAction != null) {
            Spacer(modifier = Modifier.height(24.dp))
            HawkinsButton(
                text = actionLabel,
                onClick = onAction,
                type = HawkinsButtonType.Primary
            )
        }
    }
}

/**
 * Reusable error state view with retry action button.
 */
@Composable
fun ErrorStateView(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = "Something went wrong"
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(NetflixRed.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.WifiOff,
                contentDescription = "Error",
                tint = NetflixRed,
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB3B3B3),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        HawkinsButton(
            text = "Try Again",
            onClick = onRetry,
            type = HawkinsButtonType.Brand,
            leadingIcon = Icons.Default.Refresh
        )
    }
}

