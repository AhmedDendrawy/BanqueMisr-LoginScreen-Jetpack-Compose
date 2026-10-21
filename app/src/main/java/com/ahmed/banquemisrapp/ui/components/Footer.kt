package com.ahmed.banquemisrapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.banquemisrapp.R

@Composable
fun Footer(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    HorizontalDivider(
        modifier = modifier.padding(vertical = 32.dp),
        thickness = 1.dp,
        color = Color.LightGray
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        FooterItem(
            icon = R.drawable.our_products,
            text = stringResource(R.string.our_products),
            modifier = Modifier.weight(1f)
        ) {
            Toast.makeText(context, "Our Products", Toast.LENGTH_SHORT).show()
        }
        FooterItem(
            icon = R.drawable.exchange_rate,
            text = stringResource(R.string.exchange_rate),
            modifier = Modifier.weight(1f)
        ) {
            Toast.makeText(context, "exchange rate", Toast.LENGTH_SHORT).show()
        }
        FooterItem(
            icon = R.drawable.security_tips,
            text = stringResource(R.string.security_tips),
            modifier = Modifier.weight(1f)
        ) {
            Toast.makeText(context, "security_tips", Toast.LENGTH_SHORT).show()

        }
        FooterItem(
            icon = R.drawable.nearest_branch_or_atm,
            text = stringResource(R.string.nearest_branch),
            modifier = Modifier.weight(1f)
        ) {
            Toast.makeText(context, "nearest_branch", Toast.LENGTH_SHORT).show()

        }
    }
}


@Composable
fun FooterItem(icon: Int, text: String, modifier: Modifier = Modifier, onMyClick: () -> Unit) {
    Column(
        modifier = modifier
            .clickable(onClick = onMyClick)
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(56.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            color = Color.DarkGray
        )
    }
}


@Preview
@Composable
private fun FooterPreview() {
    Footer()
}