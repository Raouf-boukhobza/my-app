package com.raouf.ecommerceapp




import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import com.raouf.ecommerceapp.ui.theme.darkgrey
import com.raouf.ecommerceapp.ui.theme.grey
import com.raouf.ecommerceapp.ui.theme.orange_red


@Composable
fun PaymentPage(){

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        content = {contentpadding ->
            Column(
                modifier = Modifier.padding(contentpadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var selecteitem by remember {
                    mutableStateOf("Master Card")
                }
                var issheetopen by rememberSaveable{
                    mutableStateOf(false)
                }
                val animatedCenterX by animateFloatAsState(
                    targetValue = if (issheetopen) 0.825f else 0.8f,
                    animationSpec = tween(durationMillis = 300) // Adjust duration as needed
                )


                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                    horizontalArrangement = Arrangement.Center
                 ){
                    PaymentCard(animatedCenterX)
                    AnimatedVisibility(
                        visible = !issheetopen,


                    ){
                        AddCard()
                    }

                }
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                Text(
                    text = "Other Way To Pay",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()

                )
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                OtherWayToPay(
                      {selecteitem == it},
                    {selecteitem = it}
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.4f))
                Amount(issheetopen){ newstate ->
                    issheetopen = newstate
                    }
                }

        },
        topBar = { Paymenttopbar() },


    )





}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paymenttopbar(){
    TopAppBar(
        title = {
        Text(
            text = "Payment",
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
            
        )

    },
        navigationIcon = {
            Icon(Icons.Outlined.ArrowBack, contentDescription = null)
        },
        actions = {
            Icon(Icons.Outlined.MoreVert, contentDescription = null)
        }


    )
}



@Composable
fun PaymentCard(
   with: Float
){
    Card(
        modifier= Modifier
            .fillMaxWidth(with)
            .fillMaxHeight()
            .clip(RoundedCornerShape(22.dp)),
        colors = CardDefaults.cardColors(
            orange_red
        ),
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(22.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth()) {
                  Text(
                      text = "Début",
                      fontSize = 18.sp,
                      color = Color.White,
                      fontWeight = FontWeight.Medium

                  )
                    Spacer(modifier = Modifier.fillMaxWidth(0.8f))

                    Canvas(modifier = Modifier
                        .fillMaxSize(0.125f)
                        .offset(y = 4.dp)) {
                        val radius = size.minDimension / 2 *5
                        val foregroundOffset = Offset(x = center.x + radius + 5, y = center.y)
                        drawCircle(
                            color = Color.White,
                            radius = radius - 6,
                            center = foregroundOffset,
                            style = Stroke(1.dp.toPx(),cap = StrokeCap.Round)

                        )
                        // Draw background circle
                        drawCircle(
                            color = Color.White,
                            radius = radius - 3
                        )

                        // Draw foreground circle with slight intersection

                    }


                }
                Icon(
                    painterResource(id = R.drawable.baseline_credit_card_24) ,
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .offset(y = 16.dp),
                    tint = Color.White

                )
                Spacer(modifier = Modifier.fillMaxHeight(0.5f))
                Row (modifier = Modifier.fillMaxWidth(0.95f),
                    horizontalArrangement = Arrangement.End){
                   Image(painter = painterResource(id = R.drawable.payment),
                       contentDescription = null,
                       modifier = Modifier.size(19.dp),
                       colorFilter = ColorFilter.lighting(Color.White , Color.White)

                       )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Locas Matias",
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )

                    Text(
                        text = "03 / 29",
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }

            }
        }


    )

}



@Composable
fun AddCard(){

    Column(modifier = Modifier
        .fillMaxSize()

        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clip(RoundedCornerShape(16.dp))
        .border(1.dp, color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(Icons.Default.Add ,
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)

        )
    }
    }


@Composable
fun OtherWayToPay(
     onselected : (String)->Boolean,
     onclick : (String)->Unit
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){

        val items = listOf(
            listOf("Master Card" ,   R.drawable.mastercardlogo) ,
             listOf("Apple Pay" , R.drawable.apple ) ,
            listOf("Cielo payment" , R.drawable.cielo))




        items.forEach{ item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))

            ){
                Row(
                    modifier = Modifier.run {
                        fillMaxWidth()
                            .background(color = grey)
                            .padding(vertical = 14.dp, horizontal = 14.dp)
                            .selectable(
                                selected = onselected(item[0].toString()),
                                role = Role.RadioButton,
                                onClick = { onclick(item[0].toString()) },

                                )


                    },

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                       Image(
                           painter =  painterResource(id = item[1] as Int),
                           contentDescription = null,
                           modifier = Modifier.size(40.dp)
                       )
                        Text(
                            text = item[0].toString(),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .offset(x = 15.dp),
                            fontSize = 18.sp
                        )
                    }


                    RadioButton(
                        selected = onselected(item[0].toString()),
                        onClick = null,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = orange_red ,
                            unselectedColor = Color.LightGray)

                        )
                }
                
            }
            Spacer(modifier = Modifier.size(height = 14.dp , width = 0.dp))
            }


    }
}



@Composable
fun Amount(
     issheetopen : Boolean,
     updatesatae : (Boolean) -> Unit
){



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = buildAnnotatedString {
                append("Amount To Pay : ")
                withStyle(
                    style = SpanStyle(
                        color = orange_red,
                        fontWeight = FontWeight.Bold
                    )

                ){
                    append("$ 444.00")
                }
            },
            fontSize = 22.sp,
            color = Color.Gray,
        )
        Button(
            onClick = {
              updatesatae(!issheetopen)
                      },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f)
                .offset(y = 8.dp),

            colors = ButtonDefaults.buttonColors(orange_red)

        ) {
            Text(
                text = "Proceed To Payment",
                fontSize = 20.sp
            )
        }
        Bottomsheet(issheetopen) {
            updatesatae(!issheetopen)
        }


    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bottomsheet(
      issheetopen : Boolean,
      updatestate : (Boolean) -> Unit
){
    val state = rememberModalBottomSheetState(
    skipPartiallyExpanded = true
    )

        if (issheetopen){
            ModalBottomSheet(
                onDismissRequest = {updatestate(!issheetopen)},
                sheetState = state,
                scrimColor = Color.Transparent,
                containerColor = Color.Black,
                modifier = Modifier
                    .fillMaxHeight(0.625f)
                    .fillMaxWidth()


            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Payment" ,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.fillMaxHeight(0.075f))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(20.dp))
                            .padding(vertical = 18.dp)
                            ,
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter =  painterResource(id = R.drawable.mastercardlogo),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.White,
                                        fontSize = 20.sp,
                                    )
                                ){
                                    append("****1234 \n")
                                  }
                                    append("payment Method")
                            },
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )

                        Icon(
                            Icons.Outlined.KeyboardArrowDown,
                             contentDescription = null,
                            Modifier.size(35.dp),
                            tint = Color.White
                        )

                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(30.dp)
                                .background(color = Color.DarkGray, shape = CircleShape)

                        ){
                                Icon(Icons.Outlined.Home,
                                    contentDescription =null,
                                    tint = Color.LightGray,
                                    modifier = Modifier
                                        .size(28.dp)
                                    )
                            }

                          Text(
                              text = buildAnnotatedString {
                                  withStyle(
                                      style = SpanStyle(
                                          color = grey,
                                          fontSize = 16.sp,
                                          fontWeight = FontWeight.Medium
                                      )

                                  ){
                                      append("Delivery Address \n")
                                  }
                                  append("street sout America \n Brazil 123")
                              },
                              fontSize = 14.sp,
                              color = Color.DarkGray
                          )
                         IconButton(
                             onClick = { /*TODO*/ },
                             modifier = Modifier
                                 .size(30.dp)
                                 .background(color = Color.DarkGray, shape = CircleShape)
                         ) {
                             Icon(Icons.Outlined.Edit,
                                 contentDescription = null,
                                 tint = Color.LightGray,
                                 modifier = Modifier
                                     .size(28.dp)
                             )
                         }


                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.2f))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                          Text(
                              text = "Total",
                              color = Color.LightGray,
                              fontSize = 16.sp
                          )
                        Text(
                              text = "$440.00",
                              color = Color.White,
                              fontSize = 24.sp
                          )
                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                    Row(modifier = Modifier
                        .fillMaxWidth()

                        .background(color = darkgrey, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 20.dp, vertical = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .size(35.dp)
                                .background(color = Color.DarkGray, shape = CircleShape)
                        ) {
                            Icon(Icons.Outlined.Edit,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .size(30.dp)
                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(orange_red),
                            modifier = Modifier
                                .size(width = 180.dp , height = 50.dp)
                        ) {
                            Text(
                                text = "Pay Now",
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }







