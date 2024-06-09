package com.easyapps.jetutils.utils

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*

@Composable
fun SlideOutVisible(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        content = content,
        visible = visible,
        modifier = modifier,
        exit = slideOutHorizontally(),
        enter = slideInHorizontally()
    )
}

@Composable
fun SlideInVisible(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        content = content,
        visible = visible,
        modifier = modifier,
        exit = slideOutVertically(targetOffsetY = { it / 2 }),
        enter = slideInVertically(initialOffsetY = { it / 2 })
    )
}


@Composable
fun ScaleVisible(
    visible: Boolean,
    modifier: Modifier = Modifier,
    duration: Int = 300,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        content = content,
        visible = visible,
        modifier = modifier,
        enter = scaleIn(tween(duration)),
        exit = scaleOut(tween(duration))
    )
}

@Composable
fun onAnimateColor(color: Color, duration: Int = 300): Color {
    val state by animateColorAsState(
        label = EMPTY,
        targetValue = color,
        animationSpec = tween(duration)
    )
    return state.copy()
}

@Composable
fun <S> AnimatedContent(
    state: S,
    modifier: Modifier = Modifier,
    content: @Composable AnimatedContentScope.(targetState: S) -> Unit
) {
    AnimatedContent(
        label = EMPTY,
        content = content,
        modifier = modifier,
        targetState = state
    )
}