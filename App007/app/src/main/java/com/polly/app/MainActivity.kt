package com.polly.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polly.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    // view Binding 을 활성화하여 사용하기 위한 객체 선언
    // Kotlin 은 변수를 선언함과 동시에 초기화(값 할당) 하는 것이 원칙이다.
    // 하지만 경우에 따라 선언과 초기화를 분리시켜야 할 때도 있다.
    // lateinit var 키워드를 사용하여 변수를 선언한다.
    private lateinit var binding:ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // binding 을 사용하기 위하여 초기화(값 할당)하기
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}