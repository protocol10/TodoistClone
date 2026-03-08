package com.akshaym.todoistclone.ui.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * A custom button component that displays an icon followed by text.
 * This version uses an [ImageVector] for the icon.
 *
 * @param onClick Callback to be invoked when the button is clicked.
 * @param imageVector The [ImageVector] to be displayed as an icon.
 * @param contentDescription Accessibility description for the icon.
 * @param iconPadding The spacing between the icon and the button text.
 * @param tintColor The color to apply to the icon (defaults to [Color.White]).
 * @param buttonText The text to be displayed on the button.
 */
@Composable
fun SocialButtons(
    onClick: () -> Unit,
    imageVector: ImageVector,
    contentDescription: String,
    iconPadding: Dp,
    tintColor: Color = Color.White,
    buttonText: String, modifier: Modifier = Modifier.fillMaxWidth()
) {
    Button(onClick = onClick, modifier = modifier, content = {
        // Used for showing specifically for icons i.e smaller icons and by default is 24 X 24
        // Officially recommended for icon buttons, if we want more flexible then we can use Image composable
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(start = 0.dp, end = iconPadding)
                .size(16.dp),
            tint = tintColor // used to change the color of the icon originally its black
        )
        Text(buttonText, textAlign = TextAlign.Center)
    })
}

/**
 * A custom button component that displays an icon followed by text.
 * This version uses a drawable resource ID for the icon.
 *
 * @param onClick Callback to be invoked when the button is clicked.
 * @param resourceId The [DrawableRes] ID of the icon to be displayed.
 * @param contentDescription Accessibility description for the icon.
 * @param iconPadding The spacing between the icon and the button text.
 * @param tintColor The color to apply to the icon (defaults to [Color.White]).
 * @param buttonText The text to be displayed on the button.
 */
@Composable
fun SocialButtons(
    onClick: () -> Unit,
    @DrawableRes resourceId: Int,
    contentDescription: String,
    iconPadding: Dp,
    tintColor: Color = Color.White,
    buttonText: String
) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth(), content = {
        // Used for showing specifically for icons i.e smaller icons and by default is 24 X 24
        // Officially recommended for icon buttons, if we want more flexible then we can use Image composable
        Icon(
            painter = painterResource(resourceId),
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(start = 0.dp, end = iconPadding)
                .size(16.dp),
            tint = tintColor // used to change the color of the icon originally its black
        )
        Text(buttonText, textAlign = TextAlign.Center)
    })
}
