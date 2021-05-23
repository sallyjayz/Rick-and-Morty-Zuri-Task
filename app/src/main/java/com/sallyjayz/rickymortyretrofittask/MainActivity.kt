package com.sallyjayz.rickymortyretrofittask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sallyjayz.rickymortyretrofittask.adapter.RickMortyAdapter
import com.sallyjayz.rickymortyretrofittask.api.CharacterViewModel
import com.sallyjayz.rickymortyretrofittask.api.RickyMortyResult

class MainActivity : AppCompatActivity() {

//    private var characters = mutableListOf<RickyMortyResult>()

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = RickMortyAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.properties.observe(this, Observer {
            adapter.submitList(it)
            Log.d("MainActivity", "onCreate: $it")
        })



    }
}