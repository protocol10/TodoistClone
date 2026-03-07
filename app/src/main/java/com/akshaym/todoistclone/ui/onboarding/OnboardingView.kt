package com.akshaym.todoistclone.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshaym.todoistclone.R
import com.akshaym.todoistclone.ui.widgets.SocialButtons

@Composable
fun OnboardingView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.str_organize_content_tag),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 0.dp, end = 16.dp, top = 32.dp),
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_onboarding),
            contentDescription = stringResource(R.string.str_content_description_onboarng_image),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 64.dp),
        )

        Spacer(modifier = Modifier.weight(0.1f))

        SocialButtons(
            onClick = { },
            imageVector = Icons.Default.Email,
            contentDescription = stringResource(R.string.str_content_description_email),
            iconPadding = 8.dp,
            tintColor = Color.White,
            buttonText = stringResource(R.string.str_continue_email)
        )
//        Button(onClick = {}, modifier = Modifier.fillMaxWidth(), content = {
//            // Used for showing specifically for icons i.e smaller icons and by default is 24 X 24
//            // Officially recommended for icon buttons, if we want more flexible then we can use Image composable
//            Icon(
//                imageVector = Icons.Default.Email,
//                contentDescription = "Google",
//                modifier = Modifier.padding(start = 0.dp, end = 8.dp),
//                tint = Color.White // used to change the color of the icon originally its black
//            )
//            Text("Continue with Email", textAlign = TextAlign.Center)
//        })
        SocialButtons(
            onClick = { },
            resourceId = R.drawable.ic_google,
            contentDescription = stringResource(R.string.str_content_description_google),
            iconPadding = 8.dp,
            tintColor = Color.White,
            buttonText = stringResource(R.string.str_continue_google)
        )
        SocialButtons(
            onClick = { },
            resourceId = R.drawable.ic_facebook,
            contentDescription = stringResource(R.string.str_content_description_facebook),
            iconPadding = 8.dp,
            tintColor = Color.White,
            buttonText = stringResource(R.string.str_continue_facebook)
        )

        val termsAndPrivacyText = buildAnnotatedString {
            append(stringResource(R.string.str_terms_agreement))
            withLink(
                LinkAnnotation.Url(
                    stringResource(R.string.str_link_terms_condition), styles = TextLinkStyles(
                        style = SpanStyle(
                            color = Color.Blue, fontWeight = FontWeight.Bold
                        )
                    )
                ), {
                    append(stringResource(R.string.str_terms_of_service))
                })
            append(" and ")
            withLink(
                LinkAnnotation.Url(
                    stringResource(R.string.str_link_privacy), styles = TextLinkStyles(
                        style = SpanStyle(
                            color = Color.Blue, fontWeight = FontWeight.Bold
                        )
                    )
                ), {
                    append(stringResource(R.string.str_privacy))
                })
            append(".")
        }
        Text(
            termsAndPrivacyText, modifier = Modifier.padding(vertical = 16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    OnboardingView()
}