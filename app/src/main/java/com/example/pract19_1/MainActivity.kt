package com.example.pract19_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currectFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currectFragment == null){
            val fragment = CrimaFragmentActivity()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}