package com.polly.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polly.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener{
            // MainActivity 에서 AddActivity 를 열기 위한 준비
            val addIntent= Intent(this@MainActivity, AddActivity::class.java)
            // Intent 시작
            startActivity(addIntent)
        }
    }
}