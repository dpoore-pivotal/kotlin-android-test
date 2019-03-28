package com.example.recyclerviewtest

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listItems: ArrayList<String> = ArrayList()
    internal var todoDatabase: TodoRoomDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoDatabase = TodoRoomDatabase.getDatabase(this)
        GetTodosFromDb(this).execute()

        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = ListItemAdapter(listItems, this)
    }

    private class InsertTodo(var context: MainActivity, var todo: Todo) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.todoDatabase!!.todoDao().insert(todo)
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

    private class GetTodosFromDb(var context: MainActivity) : AsyncTask<Void, Void, List<Todo>>() {
        override fun doInBackground(vararg params: Void?): List<Todo> {
            return context.todoDatabase!!.todoDao().getAllTodos()
        }

        override fun onPostExecute(todoList: List<Todo>?) {
            if (todoList!!.size > 0) {
                todoList.forEach { todo: Todo -> context.listItems.add(todo.value) }
            }else {
                Log.e("nothing", "no todos in DB")
            }
        }
    }

    fun addItem(view: View) {
        val newItemTextInput = findViewById<EditText>(R.id.add_item_input)
        val newItemText = newItemTextInput.text.toString()
        listItems.add(newItemText)
        InsertTodo(this, Todo(newItemText)).execute()
        newItemTextInput.text.clear()
        rv_list.adapter?.notifyDataSetChanged()
    }
}

