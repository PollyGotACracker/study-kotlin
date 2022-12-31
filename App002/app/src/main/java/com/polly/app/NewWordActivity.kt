package com.polly.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NewWordActivity : AppCompatActivity() {
    // cf) Bundle 객체는 data 저장, Intent 객체는 data 송수신
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        // MainActivity 에서 putExtra() > startActivity() 로 전달된
        // 변수(key)들에게서 값 추출하기
        // getIntExtra() 의 두 번째 인수는 default value
        val hello = intent.getStringExtra("HELLO")
        val num1 = intent.getIntExtra("NUM1", 0)
        val num2 = intent.getIntExtra("NUM2", 0)

        Log.d("NEW HELLO", hello.toString())
        Log.d("NEW NUM1", num1.toString())
        Log.d("NEW NUM2", num2.toString())

        /**
         * cf)
         * Bundle 객체에서 name(key)에 해당하는 값 얻기...
         * getIntent() : 수신 activity 를 시작시킨 intent 객체를 반환
         * getExtras() : 데이터를 포함한 해당 intent 의 Bundle 객체(=Extras 속성)를 반환
         *
         * 1. intent.extras
         *    extras.get...("name")
         *      ex)
         *      val extras = intent.extras ?: return
         *      val myString = extras.getString("myString")
         *      int myInt = extras.get:Int("myInt")
         *
         * 2. intent.getStringExtra("name")/getIntExtra("name",defaultValue)
         */
    }
}