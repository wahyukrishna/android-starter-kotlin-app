package com.dicoding.worldhelmet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHelmet: RecyclerView
    private  var list: ArrayList<Helmet> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHelmet = findViewById(R.id.rv_helmet)
        rvHelmet.setHasFixedSize(true)

        list.addAll(HelmetData.listData)
        showRecyclerList()

        val actionBar = supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menu_about -> {
                val aboutIntent = Intent(this@MainActivity, About::class.java )
                startActivity(aboutIntent)
            }
        }
    }

    private fun showRecyclerList(){
        rvHelmet.layoutManager = LinearLayoutManager(this)
        val listHelmetAdapter = ListHelmetAdapter(list)
        rvHelmet.adapter = listHelmetAdapter

    }



}