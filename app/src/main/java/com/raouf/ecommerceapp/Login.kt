package com.raouf.ecommerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack

import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raouf.ecommerceapp.ui.theme.grey
import com.raouf.ecommerceapp.ui.theme.orange_red


@Preview(showSystemUi = true)
@Composable
fun Loginpage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)

    ){
        Spacer(modifier = Modifier.fillMaxSize(0.04f))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = grey)

        ){
            IconButton(
                onClick = { /*TODO*/ },

            ) {
                Icon(Icons.Outlined.ArrowBack,
                    contentDescription =null,
                    modifier = Modifier.size(30.dp)


                )
            }
        }
        Spacer(modifier = Modifier.fillMaxSize(0.05f))

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            Text(
                text = stringResource(id = R.string.enter_account),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(14.dp)
            )
            Text(
                text = stringResource(id = R.string.login_label),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 38.dp),
                color = Color.Gray
            )
            InputText("Email","Type Your Email" ,Icons.Outlined.Email)
            InputText("Password","Type Your Password" ,Icons.Outlined.Lock)
            Spacer(modifier = Modifier.fillMaxHeight(0.12f))
            Button(
                onClick = { /*TODO*/ },
                modifier  = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.150f),
                colors = ButtonDefaults.buttonColors(
                    orange_red
                )

            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp)
            }
            Text(
                text = "Or Login With Your Social Networks",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 32.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(painter = painterResource(id = R.drawable.google),
                    contentDescription = null ,
                    modifier = Modifier.size(30.dp)
                        .clickable {  })
                Image(painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null ,
                    modifier = Modifier.size(45.dp)
                        .clickable {  }

                )
                Image(painter = painterResource(id = R.drawable.apple),
                    contentDescription = null ,
                    modifier = Modifier
                        .size(38.dp)
                        .padding(bottom = 5.dp)
                        .clickable {  })
            }




        }
    }

}


@Composable
fun InputText(
    label :String,
    hint  :String,
    icon : ImageVector,
){
    var text by remember {
        mutableStateOf("")
    }
    
    OutlinedTextField(
        value = text,
        onValueChange = { newtext ->
            text = newtext
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        label = {
            Text(
                text = label,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        },
        placeholder = {
            Text(text = hint)
        },
        leadingIcon = {
            Row {
                Icon(
                    icon,
                    contentDescription = "email",
                    modifier = Modifier.padding(8.dp)
                )

                Text(
                    text = "|",
                    fontSize = 25.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        },
        visualTransformation = if(label == "Password"){
             PasswordVisualTransformation()
        }else{
             VisualTransformation.None
        }


        )

}