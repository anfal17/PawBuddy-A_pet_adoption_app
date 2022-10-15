package com.example.pawbuddy.data

import androidx.compose.ui.text.font.FontWeight
import com.example.pawbuddy.R
import java.security.cert.CertPath

data class CatData(
    val id: Int,
    val name: String,
    val sex: String,
    val age:Int,
    val weight:Double,
    val imagePath: Int
)

var PetList = mutableListOf<CatData>(
    CatData(0,"Sheba","Female",2,2.3, R.drawable.image1),
    CatData(1,"Rex","Male",1,1.5, R.drawable.image2),
    CatData(2,"Melo","Male",4,3.0, R.drawable.image3),
    CatData(3,"Shuya","Female",2,2.2, R.drawable.image4),
    CatData(4,"Maki","Female",3,3.8, R.drawable.image5),
    CatData(5,"Chonk","Male",1,1.9, R.drawable.image6),
    CatData(6,"Kiba","Female",4,4.3, R.drawable.image7),
    CatData(7,"Beans","Male",2,2.1, R.drawable.image8)
)