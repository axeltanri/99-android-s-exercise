package com.example.team99_android_exercise

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.team99_android_exercise.SearchResult.SearchResultActivity
import com.example.team99_android_exercise.SearchResult.SearchResultAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, SearchResultActivity::class.java))
        finish()
    }
}