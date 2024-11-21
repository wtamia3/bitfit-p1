package com.example.bitfit_p1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var bitFitDatabase: BitFitDatabase
    private lateinit var bitFitAdapter: BitFitAdapter
    private val entries = mutableListOf<BitFitEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bitFitDatabase = BitFitDatabase.getDatabase(this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        bitFitAdapter = BitFitAdapter(entries)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = bitFitAdapter

        findViewById<Button>(R.id.addEntryButton).setOnClickListener {
            startActivity(Intent(this, CreateEntryActivity::class.java))
        }

        loadEntries()
    }

    private fun loadEntries() {
        CoroutineScope(Dispatchers.IO).launch {
            entries.clear()
            entries.addAll(bitFitDatabase.bitFitDao().getAllEntries())
            runOnUiThread { bitFitAdapter.notifyDataSetChanged() }
        }
    }
}
