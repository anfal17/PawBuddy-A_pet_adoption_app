package com.example.pawbuddy.ui.screen

import android.graphics.Color.blue
import android.graphics.Color.red
import android.support.v4.os.IResultReceiver
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawbuddy.R
import com.example.pawbuddy.data.CatData
import com.example.pawbuddy.data.PetList
import com.example.pawbuddy.ui.theme.PawBuddyTheme
import com.example.pawbuddy.ui.theme.blueBGNight
import com.example.pawbuddy.ui.theme.cardNight

@Composable
fun HomeScreen(navController: NavController){
    Scaffold() {
        Box(
            modifier = Modifier
                .background(blueBGNight)
                .padding(10.dp)
                .fillMaxSize()
        ) {
            LazyColumn(){
                item {
                    Header()
                    Spacer(modifier = Modifier.height(24.dp))
//                    Text(text = "New Pets" , TextStyle(color = Color.White, fontWeight = FontWeight.Bold))
                }
                items(PetList.size){
                    item -> PetListItem(item = PetList[item], onCardClick = {
                        item -> navController.navigate(("details/${item.id}"))
                })
                }
            }
        }
    }
}

@Composable
fun Header(name: String = "Hooman"){
    Row(
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically,
       modifier = Modifier.fillMaxWidth().padding(10.dp)
    ){
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Hey $name,",
                style = MaterialTheme.typography.h3,
                fontSize = 25.sp,
                color = Color.White
                )
            Text(
                text = "Adopt a Forever Friend today!",
                style = MaterialTheme.typography.body1,
                fontSize = 18.sp,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_pets_24),
            contentDescription = "A Pet Icon",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .rotate(-45.0f)
            )
    }
}


@Composable
fun PetListItem(item:CatData,onCardClick : (CatData)-> Unit){
    Card(backgroundColor = cardNight,
        modifier = Modifier
            .padding(bottom = 6.dp)
            .clip(RoundedCornerShape(size = 24.dp))
            .clickable(onClick = { onCardClick( item ) }, enabled = true)
            .padding(8.dp),
            elevation = 0.dp
    ) {
        Column(Modifier.padding(8.dp)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = Color.Gray),
                    Alignment.Center
            ){
                Image(painter = painterResource(id = item.imagePath),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                    )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                item.name,
                style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            )
            PetDetails(age = item.age, Weight = item.weight, sex = item.sex)
        }

    }
}


@Composable
fun PetDetails(age:Int,Weight: Double,sex: String){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Column(
            modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ) {
                val year= if (age > 1) "Years" else "Year"
                Text(
                    text = "Age",
                    style = TextStyle(
                        color = Color(0xaaFFFFFF),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                        ),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "$age $year",
                    textAlign = TextAlign.Center,
                    color = Color(0xFfdfdfdf)
                    )
        }

        Column(
            modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ) {
            val year= if (age > 1) "Years" else "Year"
            Text(
                text = "Weight",
                style = TextStyle(
                    color = Color(0xaaFFFFFF),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )

            Text(
                text = "$Weight kg",
                textAlign = TextAlign.Center,
                color = Color(0xFfdfdfdf)
            )
        }
        
        GenderTag(sex)
    }
}




@Composable
fun GenderTag(name: String) {
    val color = if (name == "Male") R.color.blue else R.color.red
    ChipView(gender = name, colorResource = colorResource(id = color))
}

@Composable
fun ChipView(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = gender, modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}




