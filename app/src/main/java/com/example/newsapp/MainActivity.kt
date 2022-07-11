package com.example.newsapp

import android.os.Bundle
import com.example.newsapp.util.base.BottomNavigationActivity

class MainActivity : BottomNavigationActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }
}