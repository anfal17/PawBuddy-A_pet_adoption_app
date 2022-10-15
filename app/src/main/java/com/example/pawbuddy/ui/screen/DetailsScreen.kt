package com.example.pawbuddy.ui.screen

import android.content.ClipData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pawbuddy.data.CatData
import java.nio.file.WatchEvent
import androidx.compose.material.IconButton as IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.pawbuddy.R
import com.example.pawbuddy.ui.theme.*

@Composable
fun DetailsScreen(navController: NavController, CatData:CatData) {
      Scaffold(
          topBar = {
              TopAppBar(
                  navigationIcon = {
                      IconButton(onClick = { navController.popBackStack() }) {
                          Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White )
                          
                      }
                  },
                  modifier = Modifier.height(68.dp),
                  title = { Text(text = "Details", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                  actions = { IconButton(onClick = { /*TODO*/ }) {  Icon(
                      imageVector = Icons.Filled.Favorite,
                      contentDescription = null,
                      tint = Color.White
                  )
                      
                  }},
                  elevation = 0.dp,
                  backgroundColor = blueBGNight,
                  contentColor = Color.White
              )
          },
//          bottomBar = {
//              Row(Modifier.padding(16.dp)) {
//                  Button(onClick = {} ,
//                      Modifier
//                          .fillMaxWidth()
//                          .height(53.dp),
//                      colors = ButtonDefaults.buttonColors(backgroundColor = LightPurple),
//                      elevation = ButtonDefaults.elevation(0.dp)
//                  ) {
//                      Text(text = "Adopt Me",style = MaterialTheme.typography.h5 )
//                  }
//              }
//          },
          backgroundColor = blueBGNight,
          contentColor = Color.White
      ) {
          Body(Modifier.padding(16.dp),CatData = CatData ,CatData.sex)
      }
}

@Composable
fun Body(modifier: Modifier,CatData: CatData,sex: String) {
    LazyColumn(modifier = Modifier) {

       //cat image
        item {
            Image(
                painter = painterResource(id = CatData.imagePath),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))
        }


        // cat name and gender
        item {
            Row(modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = CatData.name, style = MaterialTheme.typography.h4)

                GenderTag(sex)

            }

//            Spacer(modifier = Modifier.height(6.dp))
        }


        item {
            Row(modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                    contentDescription = "A Pet Icon",
                    tint = Color.Red,
                    modifier = Modifier
                        .size(32.dp))

                Text(text = "Bengaluru", style = MaterialTheme.typography.h6,modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth(),
                    fontSize = 15.sp )
            }

        }


        item {
            Text(text = "My Story", style = MaterialTheme.typography.h6,modifier = Modifier
                .padding(start = 18.dp ,6.dp)
                .fillMaxWidth())

            Spacer(modifier = Modifier.height(3.dp))
        }

        item {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(18.dp)
            )
        }

        item {
            Text(text = "Quick Info", style = MaterialTheme.typography.h6,modifier = Modifier.padding(18.dp))
        } 
        
        item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    val mod = Modifier
                        .clip(shape = RoundedCornerShape(size = 12.dp))
                        .weight(1f)
                        .background(cardNight)
                        .padding(8.dp)

                    DetailsBox(title = "Gender", info = "${CatData.sex}", mod)
                    Spacer(modifier = Modifier.width(16.dp))
                    DetailsBox(title = "Age", info = "${CatData.age}", mod)
                    Spacer(modifier = Modifier.width(16.dp))
                    DetailsBox(title = "Weight", info = "${CatData.weight}", mod)

                }
            }

        item {
            Text(text = "Owner Info", style = MaterialTheme.typography.h6,modifier = Modifier.padding(18.dp))
        }

        item { 
            Row(modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start)            {
                Image(painter = painterResource(id = R.drawable.img1), contentDescription = null,modifier = Modifier
                    .width(60.dp)
                    .height(60.dp))

                 Text(text = "Owner Name", style = MaterialTheme.typography.h6,modifier = Modifier.padding(18.dp))

            }
        }

        //button
        item{
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .background(color = Color.Blue)) {
                Text(text = "Adopt me", style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        }
        
    }
}

@Composable
fun DetailsBox(title:String, info:String, modifier : Modifier = Modifier){
    Box(modifier = modifier) {
        Column() {
            Text(text = title, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(text = info, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }

}