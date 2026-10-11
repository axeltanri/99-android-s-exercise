package com.example.team99_android_exercise.SearchResult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99_android_exercise.Model.ListProperty
import com.example.team99_android_exercise.R

class SearchResultAdapter (
    private val onItemClick: (ListProperty) -> Unit
): RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    private var _items: List<ListProperty> = emptyList()
    fun setData(newItems: List<ListProperty>){
        _items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_result_box, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val property = _items[position]
        holder.tvProjectName.text = property.projectName
        holder.tvStreetName.text = "${property.address.streetName} · ${property.address.district}"
        holder.tvCategory.text = "${property.category} · ${property.completedAt} · ${property.tenure} yrs"
        holder.tvAttributes.text = "${property.attributes.bedrooms} Beds · ${property.attributes.bathrooms} Baths · ${property.attributes.areaSize} sqft"
        holder.tvPrice.text = "$${property.attributes.price}/mo"

        Glide.with(holder.ivImage.context)
            .load(property.photo)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.ivImage)

        holder.itemView.setOnClickListener {
            onItemClick(property)
        }
    }

    override fun getItemCount(): Int = _items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvProjectName: TextView = view.findViewById(R.id.tvProjectName)
        val tvStreetName: TextView = view.findViewById(R.id.tvStreetName)
        val tvCategory: TextView = view.findViewById(R.id.tvCategory)
        val tvAttributes: TextView = view.findViewById(R.id.tvAttributes)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val ivImage: ImageView = view.findViewById(R.id.ivImage)
    }
}
