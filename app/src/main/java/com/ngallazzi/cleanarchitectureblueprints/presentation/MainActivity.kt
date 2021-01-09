package com.ngallazzi.cleanarchitectureblueprints.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ngallazzi.cleanarchitectureblueprints.R


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}