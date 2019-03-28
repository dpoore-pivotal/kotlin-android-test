package com.example.recyclerviewtest

import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.util.Log
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
            DeleteTodo(context, Todo(listItems[position])).execute()
            listItems.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount - position)
        }
    }

    private class DeleteTodo(var context: MainActivity, var todo: Todo) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.todoDatabase!!.todoDao().delete(todo)
            return true
        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Log.d("************", "success")
            } else {
                Log.e("fail", ":(")
            }
        }
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val listItemText = view.list_item_text!!
    val checkmark = view.checkmark!!
}