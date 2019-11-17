package com.muscode.scrollbasics.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muscode.scrollbasics.R
import com.muscode.scrollbasics.adapter.FruitAdapter
import com.muscode.scrollbasics.model.FruitModel
import kotlinx.android.synthetic.main.activity_scrolling.*


class ScrollingActivity : AppCompatActivity() {


    private val myImageList = intArrayOf(
        R.drawable.apple,
        R.drawable.mango,
        R.drawable.straw,
        R.drawable.pineapple,
        R.drawable.orange,
        R.drawable.blue,
        R.drawable.water
    )
    private val myImageNameList =
        arrayOf("Apple", "Mango", "Strawberry", "Pineapple", "Orange", "Blueberry", "Watermelon")

    private lateinit var adapter: FruitAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)


        initAdapter()
        initRecyclerAdapter()

    }

    private fun initAdapter() {
        adapter = FruitAdapter(this, fruitList())
    }


    private fun initRecyclerAdapter() {
        rv_horizontal_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_horizontal_list.adapter = adapter

        rv_vertical_list.layoutManager = LinearLayoutManager(this)
        rv_vertical_list.adapter = adapter

    }

    private fun fruitList(): ArrayList<FruitModel> {
        val list = ArrayList<FruitModel>()

        for (i in 0..6) {
            list.add(FruitModel(myImageNameList[i], myImageList[i]))
        }

        return list
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
