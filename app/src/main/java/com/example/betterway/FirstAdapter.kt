package com.example.betterway

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FirstAdapter (val context: Context, val items: ArrayList<Model>, private val onCategoryClickListener: OnCategoryClickListener):RecyclerView.Adapter<FirstAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

return ViewHolder (
    LayoutInflater.from(context).inflate(
        R.layout.first_item,
    parent, false)
)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item= items[position]
        holder.textView.text = item.name

        holder.itemView.setOnClickListener {
            onCategoryClickListener.onCategoryItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView = view.findViewById(R.id.first_textView) as TextView





    }
}