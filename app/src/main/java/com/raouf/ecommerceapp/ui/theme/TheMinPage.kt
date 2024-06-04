package com.raouf.ecommerceapp.ui.theme

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.raouf.ecommerceapp.R


@Composable
fun min_page(){
    Scaffold(
        content = { paddingValues ->
            var paddingValue = paddingValues
        },
        modifier= Modifier.fillMaxSize(),
        topBar = {
         topappbar()
        }
       )
}


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topappbar(){
    TopAppBar(
        title = {},
        modifier =Modifier.fillMaxWidth(),
        navigationIcon = {
             IconButton(
                 onClick = { /*TODO*/ }
             ) {
                 Icon(Icons.Default.ArrowBack, contentDescription = null)
             }
        },
        actions = {
            Myicon(text = "1", icon =R.drawable.hopping_bag)
            Myicon(text = "4", icon = R.drawable.notifications)
        }


    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Myicon(
    text  :String,
    icon : Int
){
    IconButton(
        onClick = {  },
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.2f)
    ){
        BadgedBox(
            badge= {
                Badge(
                    containerColor = red,
                    contentColor = Color.White,
                ){
                    Text(text = text)
                }
            }
        ){
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null )
        }

    }
}