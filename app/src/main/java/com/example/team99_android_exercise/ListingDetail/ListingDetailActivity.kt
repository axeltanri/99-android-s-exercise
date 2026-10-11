package com.example.team99_android_exercise.ListingDetail

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99_android_exercise.R

class ListingDetailActivity: AppCompatActivity(){

    companion object{
        const val EXTRA_LISTING_ID = "LISTING_ID"
    }
    private val viewModel: ListingDetailViewModel by viewModels()
    private val adapter = ListingDetailAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_details_layout)

        val tvProjectName = findViewById<TextView>(R.id.tvProjectName)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvSubTitle = findViewById<TextView>(R.id.tvSubTitle)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)
        val tvBedrooms = findViewById<TextView>(R.id.tvBedrooms)
        val tvBathrooms = findViewById<TextView>(R.id.tvBathrooms)
        val tvAreaSize = findViewById<TextView>(R.id.tvAreaSize)
        val recyclerView = findViewById<RecyclerView>(R.id.detailRecyclerView)
        val ivImage = findViewById<ImageView>(R.id.ivImage)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.propertyDetail.observe(this) { detail ->
            Glide.with(this)
                .load(detail.photo)
                .into(ivImage)

            tvProjectName.text = detail.projectName
            tvTitle.text = detail.address.title
            tvSubTitle.text = detail.address.subtitle
            tvDescription.text = detail.description
            tvPrice.text = "$${detail.attributes.price}/mo"
            tvBedrooms.text = "${detail.attributes.bedrooms} Beds"
            tvBathrooms.text = "${detail.attributes.bathrooms} Baths"
            val formattedArea = java.text.NumberFormat.getInstance().format(detail.attributes.areaSize)
            tvAreaSize.text = "$formattedArea sqft"

            adapter.setData(detail.propertyDetails)
        }

        viewModel.error.observe(this){
            message-> Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        val id = intent.getIntExtra(EXTRA_LISTING_ID, -1)
        if (id != -1){
            viewModel.loadPropertyDetail(id)
        }
    }
}