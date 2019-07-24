package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val perform = findViewById<Button>(R.id.perform)
        perform.setOnClickListener {
            val file1 = File(Environment.getExternalStorageDirectory(), filepath.text.toString())
            val file2 = File(Environment.getExternalStorageDirectory(), filepath2.text.toString())
            var text1 = ""
            var text2 = ""
            var key = true
            try {
                text1 = file1.readText()
            } catch (e: FileNotFoundException) {
                filepath.setText("error", TextView.BufferType.EDITABLE)
                key = false
            }
            try {
                text2 = file2.readText()
            } catch (e: FileNotFoundException) {
                filepath2.setText("error", TextView.BufferType.EDITABLE)
                key = false
            }
            if (key) {
                val bufferedWriter = BufferedWriter(FileWriter(file1))
                val bufferedWriter2 = BufferedWriter(FileWriter(file2))
                bufferedWriter.write(text2)
                bufferedWriter2.write(text1)
                bufferedWriter.close()
                bufferedWriter2.close()
            }
        }
    }
}
