package com.example.recyclerviewtest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class ListItemAdapter(private val listItems: ArrayList<String>, private val context: MainActivity) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listItemText.text = listItems[position]

        holder.checkmark.setOnClickListener {
            listItems.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount - position)
        }
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val listItemText = view.list_item_text!!
    val checkmark = view.checkmark!!
}