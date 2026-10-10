package com.example.team99_android_exercise.SearchResult

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99_android_exercise.R


class SearchResultActivity : AppCompatActivity(){
    private val viewModel: SearchResultViewModel by viewModels()
    private val adapter = SearchResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_result_layout)

        val searchResultView = findViewById<RecyclerView>(R.id.search_result_screen)
        searchResultView.layoutManager = LinearLayoutManager(this)
        searchResultView.adapter = adapter

        viewModel.listSearchResult.observe(this){
            list -> adapter.setData(list)
        }

        viewModel.error.observe(this){
            message -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        viewModel.loadSearchResult()

    }
}