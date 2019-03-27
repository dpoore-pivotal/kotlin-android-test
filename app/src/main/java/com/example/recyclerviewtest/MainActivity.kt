package com.example.recyclerviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listItems: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // text data
        listItems.add("one")
        listItems.add("two")
        listItems.add("three")
        listItems.add("four")
        listItems.add("five")
        listItems.add("six")

        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = ListItemAdapter(listItems, this)
    }

    fun addItem(view: View) {
        val newItemTextInput = findViewById<EditText>(R.id.add_item_input)
        val newItemText = newItemTextInput.text.toString()
        listItems.add(newItemText)
        newItemTextInput.text.clear()
        rv_list.adapter?.notifyDataSetChanged()
    }
}
