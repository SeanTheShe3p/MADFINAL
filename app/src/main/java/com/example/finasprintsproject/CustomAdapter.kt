package com.example.finasprintsproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class CustomAdapter(var ctx: Context, var ourResource: Int,
                      var items: ArrayList<Model>):ArrayAdapter<Model>(ctx, ourResource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflator = LayoutInflater.from(ctx)
        val view =layoutInflator.inflate(ourResource, null)

        // goto layout and get the links to our items
        val name = view.findViewById<TextView>(R.id.name)


        name.text = items[position].Name


        return view
    }


}