package com.raouf.ecommerceapp

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun setupnevhost(
    navController: NavHostController
){
    NavHost(
        navController = navController ,
        startDestination =Screen.getstarted.name
    ){
      composable(route = Screen.getstarted.name){
          Getstarted(navController)
      }
        composable(route = Screen.loginpage.name){
            Loginpage()
        }
    }
}