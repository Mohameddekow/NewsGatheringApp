package com.dekow.newsgatheringapp.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val MyCustomShapes = Shapes(

    large = CutCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomEnd = 30.dp,
        bottomStart = 30.dp
    )
)