package com.app.longexposurecalculator.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.OutlinedButton
import androidx.wear.compose.material.Text

@Composable
fun AppButton(
    modifier: Modifier,
    image: ImageVector? = null,
    imageRes: Int? = null,
    imageTint: Color = Color.Unspecified,
    enabled: Boolean,
    text: String?,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        onClick = onClick
    ) {

    }
    Button(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        enabled = enabled,
        colors = buttonColors,
        onClick = onClick
    ) {
        if (image != null) {
            Icon(imageVector = image, contentDescription = null)
        }
        if (imageRes != null) {
            Icon(
                painter = painterResource(id = imageRes),
                tint = imageTint,
                contentDescription = null
            )
        }

        if (!text.isNullOrEmpty()) {
            if (image != null || imageRes != null) {
                Spacer(modifier = Modifier.size(ButtonDefaults.SmallIconSize))
            }
            Text(
                text = text,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun AppButtonWithValue(
    modifier: Modifier,
    image: ImageVector? = null,
    imageRes: Int? = null,
    imageTint: Color = Color.Unspecified,
    enabled: Boolean,
    text: String?,
    value: String?,
    buttonColors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        enabled = enabled,
        colors = buttonColors,
        onClick = onClick,
    ) {
        Row {
            if (image != null) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                        .size(18.dp),
                    imageVector = image,
                    contentDescription = null
                )
            }
            if (imageRes != null) {
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(id = imageRes),
                    tint = imageTint,
                    contentDescription = null
                )
            }

            if (!text.isNullOrEmpty()) {
                if (image != null || imageRes != null) {
                    Spacer(modifier = Modifier.size(10.dp))
                } else {
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Text(
                    text = text,
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .weight(1f),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2
                )

                if (!value.isNullOrEmpty()) {
                    Text(
                        text = value,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 10.dp),
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}