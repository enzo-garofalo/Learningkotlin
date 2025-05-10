package com.time2.learningui_ux.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.time2.learningui_ux.R


data class userCategory(
    var iconName: String = "",
    var title: String = "",
    var searchFor : () -> Unit,
    var numOfpasswords : Int? = null
)


@Composable
fun getCategoryIcon(iconName: String): Painter {
    return when (iconName) {
        "social" -> painterResource(id = R.drawable.ic_people)
        "pinpad" -> painterResource(id = R.drawable.ic_pin)
        "bank" -> painterResource(id = R.drawable.ic_bank)
        else -> painterResource(id = R.drawable.ic_bank) // Fallback icon
    }
}



@Composable
fun buildCategoryCases(
    categoryList: List<userCategory>
) {
    LazyRow(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),

    ) {
        itemsIndexed(categoryList) {index, item ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Transparent)
                    .clickable { item.searchFor() }
                    .border(width = 0.2.dp, color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                    .padding(12.dp)
            ){
                // Mini Card
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Transparent)
                ) {
                    // Bolinha de fundo do icone
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(
                            painter = getCategoryIcon(item.iconName),
                            contentDescription = item.title,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )

                    Text(
                        text = "${item.numOfpasswords} senhas",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}


@Composable
fun showCategoryElements()
{
    val categoryList = listOf<userCategory>(
        userCategory(
            iconName = "bank",
            title = "Banco",
            searchFor = {/*TODO*/},
            numOfpasswords = 4
        ),
        userCategory(
            iconName = "social",
            title = "Social",
            searchFor = {/*TODO*/},
            numOfpasswords = 0
        ),
        userCategory(
            iconName = "pinpad",
            title = "pinpad",
            searchFor = {/*TODO*/},
            numOfpasswords = 4
        ),
    )

    buildCategoryCases(categoryList)
}