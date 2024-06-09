package com.easyapps.jetutils.utils

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.*

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