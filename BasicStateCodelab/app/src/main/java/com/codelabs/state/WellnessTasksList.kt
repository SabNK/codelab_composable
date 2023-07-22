/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codelabs.state

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.codelabs.state.ui.theme.BasicStateCodelabTheme

/*
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            /**
             * Use key param to define unique keys representing the items in a mutable list,
             * instead of using the default key (list position). This prevents unnecessary
             * recompositions.
             */
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}
*/

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    list: List<WellnessTask>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = {checked -> onCheckedTask(task, checked)},
                onClose = {onCloseTask(task)})
        }
    }
}

@Composable
fun SurveyAnswer() {
    Row {
        Image(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
        Text(text = "Spark", color = Color(0xFFFF9800))
    }
}
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF03A9F4)
@FontScalePreviews
@DarkLightPreviews
@Composable
fun SurveyAnswerPreview() {
    BasicStateCodelabTheme() {
        SurveyAnswer()
    }
}


@Preview(name = "smallfont", group = "font scales", fontScale = 0.5f)
@Preview(name = "largefont", group = "font scales", fontScale = 1.5f)
annotation class FontScalePreviews

@Preview(
    name = "Dark mode",
    group = "UI mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true)
@Preview(
    name = "light mode",
    group = "UI mode",
    fontScale = 1.5f,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true)
annotation class DarkLightPreviews

//https://developer.android.com/jetpack/compose/tooling#live-edit