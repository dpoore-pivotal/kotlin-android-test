package com.example.recyclerviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listItems: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initial test items, delete after we can add our own
        listItems.add("foo")
        listItems.add("bar")
        listItems.add("baz")

        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = ListItemAdapter(listItems, this)
    }
}
