package com.example.recyclerviewtest

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ListItemAdapterTest {

    private val mainActivity: MainActivity = MainActivity()
    private val listItems: ArrayList<String> = ArrayList()
    private var adapter: ListItemAdapter? = null


    @Before
    fun setupListItemsAndAdapter() {
        listItems.add("one")
        listItems.add("two")

        adapter = ListItemAdapter(listItems, mainActivity)
    }

    @Test
    fun getItemCount__returnsNumberOfItemsInList() {
        assertEquals(adapter?.itemCount, listItems.size)
    }
}
