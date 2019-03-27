package com.example.recyclerviewtest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class ListItemAdapter(val listItems: ArrayList<String>,val context: MainActivity) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listItemText.text = listItems.get(position)
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val listItemText = view.list_item_text!!
}