package com.stekrdzavac.android.composeful.button

/*
 * Copyright (C) 2022 Stefan Krdzavac.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 *
 * Button widget with progress bar component, primarily intended for use in loading data on button
 * click scenarios. Loading is triggered by passing desired value of [loading] parameter.
 * This button contains [Text] for showing button label. Pass desired label via [buttonText] parameter.
 * State of loading is hoisted outside of this component scope to provide more flexibility
 * to developers and to adhere to state hoisting pattern.
 * More about it can be read [here](https://developer.android.com/jetpack/compose/state#state-hoisting)
 *
 * @param onButtonClick Will be called when the user clicks the button
 * @param buttonText Value of button text label
 * @param modifier Modifier to be applied to the button
 * @param buttonTextColor Text color of button text label
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param loading Controls the loading state of the button. When `true`, this button will show
 * loading indicator and text label otherwise.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Button. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Button in different [Interaction]s.
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Pass `null` here to disable
 * elevation for this button. See [ButtonDefaults.elevation].
 * @param shape Defines the button's shape as well as its shadow
 * @param border Border to draw around the button
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
 * @param contentPadding The spacing values to apply internally between the container and the content
 * @param enterAnim - EnterTransition(s) used for the appearing animation, fading in by default
 * @param exitAnim - ExitTransition(s) used for the disappearing animation, fading out by default
 */
@Composable
fun ProgressButton(
    onButtonClick: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier,
    buttonTextColor: Color = MaterialTheme.colors.onPrimary,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    enterAnim: EnterTransition = fadeIn(),
    exitTransition: ExitTransition = fadeOut()
) {
    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        Button(
            onClick = {
                if (!loading) {
                    onButtonClick.invoke()
                }
            },
            enabled = enabled,
            interactionSource = interactionSource,
            elevation = elevation,
            shape = shape,
            border = border,
            colors = colors,
            contentPadding = contentPadding,
            modifier = modifier.align(Alignment.Center),
        ) {
            Text(
                text = buttonText,
                color = if (loading) colors.backgroundColor(enabled = enabled).value else buttonTextColor,
            )
        }

        AnimatedVisibility(
            visible = loading,
            modifier = Modifier
                .align(Alignment.Center),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Surface(
                modifier = Modifier
                    .size(34.dp)
                    .padding(4.dp),
                color = colors.backgroundColor(enabled = enabled).value
            ) {
                CircularProgressIndicator(
                    color = buttonTextColor,
                )
            }
        }
    }
}

/**
 *
 * Button widget with progress bar component, primarily intended for use in loading data on button
 * click scenarios. Loading is triggered by passing desired value of [loading] parameter.
 * This button does not contain any content, therefore desired content Composable should be passed through
 * [content] parameter.
 * State of loading is hoisted outside of this component scope to provide more flexibility
 * to developers and to adhere to state hoisting pattern.
 * More about it can be read here <a href="https://developer.android.com/jetpack/compose/state#state-hoisting"  class="external" target="_blank">State Hoisting</a>
 *
 * @param onButtonClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param loading Controls the loading state of the button. When `true`, this button will show
 * loading indicator and text label otherwise.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Button. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Button in different [Interaction]s.
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Pass `null` here to disable
 * elevation for this button. See [ButtonDefaults.elevation].
 * @param shape Defines the button's shape as well as its shadow
 * @param border Border to draw around the button
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
 * @param contentPadding The spacing values to apply internally between the container and the content
 * @param enterAnim - EnterTransition(s) used for the appearing animation, fading in by default
 * @param exitAnim - ExitTransition(s) used for the disappearing animation, fading out by default
 * @param content Composable to show inside button.
 */
@Composable
fun ProgressButton(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    enterAnim: EnterTransition = fadeIn(),
    exitTransition: ExitTransition = fadeOut(),
    content: @Composable RowScope.() -> Unit
) {
    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        Button(
            onClick = {
                if (!loading) {
                    onButtonClick.invoke()
                }
            },
            enabled = enabled,
            interactionSource = interactionSource,
            elevation = elevation,
            shape = shape,
            border = border,
            colors = colors,
            contentPadding = contentPadding,
            content = content,
            modifier = modifier.align(Alignment.Center)
        )

        AnimatedVisibility(
            visible = loading,
            modifier = Modifier.align(Alignment.Center),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            if (loading) {
                Surface(
                    color = colors.backgroundColor(enabled = enabled).value,
                    modifier = modifier.align(Alignment.Center).fillMaxHeight()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.wrapContentSize(),
                        color = MaterialTheme.colors.onPrimary,
                    )
                }
            }
        }
    }
}