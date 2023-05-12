package com.example.finasprintsproject


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

lateinit var listView: ListView
lateinit var addButton: Button

class Chores : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chores)

        val listView = findViewById<ListView>(R.id.choreList)
        //var names = arrayOf("Sean", "David", "Suyeta", "Widdowson")
        var list = ArrayList<Model>()

        list.add(Model("Dave"))
        list.add(Model("Sean"))


        listView.adapter = CustomAdapter(this, R.layout.chorelistlayoutitem, list)

        addButton = findViewById(R.id.addChore)
        addButton.setOnClickListener {
            var additem = findViewById<EditText>(R.id.addChore).text
            list.add(Model(additem.toString()))
        }

        listView.setOnItemClickListener { CustomAdapter, view, i, l ->
            Toast.makeText(this, "This is " + list[i], Toast.LENGTH_SHORT).show()
        }
    }
}