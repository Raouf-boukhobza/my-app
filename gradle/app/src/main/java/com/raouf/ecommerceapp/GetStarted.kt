package com.raouf.ecommerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raouf.ecommerceapp.ui.theme.Orange
import com.raouf.ecommerceapp.ui.theme.red

@Preview(showSystemUi = true)
@Composable
fun Getstarted(){
    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
       Image(
           painter =painterResource(id = R.drawable.capture),
            contentDescription = null,
           modifier = Modifier.fillMaxSize()
       )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                             Orange.copy(0.75f),
                             red
                        ),
                        400f
                    )
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 12.dp, horizontal = 25.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(

                    text = "Style Over Fashion",
                    color = Color.White,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(0.6f)
                )
                Text(
                    text = stringResource(id = R.string.label) ,
                    color = Color.White,
                    fontSize = 16.sp

                )
            }
        }


    }
}