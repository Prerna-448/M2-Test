package com.example.m2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, HomeFragment())
            .commit()

        bottomNav = findViewById(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener {

            when(it.itemId){
                R.id.flower -> {

                }
            }


            return@setOnItemSelectedListener true
        }

    }
}