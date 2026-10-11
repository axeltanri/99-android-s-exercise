package com.example.team99_android_exercise.ListingDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.team99_android_exercise.Model.PropertyDetailItem
import com.example.team99_android_exercise.R

class ListingDetailAdapter: RecyclerView.Adapter<ListingDetailAdapter.ViewHolder>() {

    private var _items: List<PropertyDetailItem> = emptyList()

    fun setData(newItems: List<PropertyDetailItem>?){
        _items = newItems ?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.property_details_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val detail = _items[position]

        holder.tvLabel.text = detail.label
        holder.tvText.text = detail.text
    }

    override fun getItemCount(): Int = _items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvLabel: TextView = view.findViewById(R.id.tvLabel)
        val tvText: TextView = view.findViewById(R.id.tvText)

    }




}