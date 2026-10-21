package com.ahmed.banquemisrapp.ui.components

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.ahmed.banquemisrapp.R
import com.ahmed.banquemisrapp.ui.theme.BanqueMisrRed

@Composable
fun Header(modifier: Modifier = Modifier) {
    val currentAppLocales = AppCompatDelegate.getApplicationLocales()
    val isCurrentLanguageArabic = currentAppLocales.get(0)?.language == "ar"
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.bm_icon),
            contentDescription = "bm Icon",
        )
        Text(
            text = if (isCurrentLanguageArabic) "EN" else "العربية",
            color = BanqueMisrRed,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                val targetLanguage = if (isCurrentLanguageArabic) "en" else "ar"

                val appLocale = LocaleListCompat.forLanguageTags(targetLanguage)
                AppCompatDelegate.setApplicationLocales(appLocale)
            }
        )
    }
}