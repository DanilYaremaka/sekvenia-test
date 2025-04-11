package com.example.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.selection

@Composable
fun CustomSnackBar(
	snackBarData: SnackbarData,
) {
	Snackbar(
		modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
		action = {
			snackBarData.visuals.actionLabel?.let { actionLabel ->
				TextButton(
					onClick = { snackBarData.performAction() },
					colors = ButtonDefaults.textButtonColors(
						contentColor = selection
					)
				) {
					Text(
						text = actionLabel.uppercase(),
						fontSize = 14.sp,
						lineHeight = 16.sp,
						letterSpacing = TextUnit(value = 0f, type = TextUnitType.Sp),
						fontWeight = FontWeight.W500,
					)
				}
			}
		}
	) {
		Text(snackBarData.visuals.message)
	}
}