package com.example.bitfit_p1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateEntryActivity : AppCompatActivity() {

    private lateinit var bitFitDatabase: BitFitDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_entry)

        bitFitDatabase = BitFitDatabase.getDatabase(this)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val metricType = findViewById<EditText>(R.id.metricTypeEditText).text.toString()
            val value = findViewById<EditText>(R.id.valueEditText).text.toString()
            val date = find