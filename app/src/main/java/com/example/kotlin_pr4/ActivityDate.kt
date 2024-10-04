package com.example.kotlin_pr4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_pr4.databinding.ActivityDateBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class ActivityDate : AppCompatActivity() {

    private lateinit var binding: ActivityDateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val file = File(applicationContext.filesDir, "/photos/date.txt")
        val inputStream = FileInputStream(file)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val data = mutableListOf<String>()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            line?.let { data.add(it) }
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}