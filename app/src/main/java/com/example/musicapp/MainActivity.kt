package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    //login Details
    //api_ket = 2dd23434e16ee35163e3473b4957150e



    companion object{
        var apiToken = "2dd23434e16ee35163e3473b4957150e"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
/*

        method:album.gettoptags
        artist:radiohead
        album:the%20bends
        api_key:{{tokenKey}}
        format:json
*/

    }


}