package com.polly.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val getResultText = registerForActivityResult()

        // findViewById() 함수가 return 하는 type 이 Floating... 임을 선언
        // <FloatingActionButton> 으로 설정한 type 과 R.id.add_word 로 선택된 대상의
        // type 이 일치하지 않으면 컴파일 오류가 난다.
        // <> 사이에 type 을 명시하는 것을 Generic 설정이라고 한다(Generic type).

        // activity_main.xml 파일의 add_word 라는 id 를 가진 FloatingActionButton 을 변수로 선언
        // document.querySelector() 같은 느낌
        val addWord = findViewById<FloatingActionButton>(R.id.add_word)
        addWord.setOnClickListener{

            /**
             * MainActivity 에서 다른 Activity 화면 열기(Activity 전환)
             *
             * NewWordActivity::class.java
             *      Kotlin 으로 작성한 class 파일(*.kt, 소스코드)은
             *      컴파일이 된 후 java class 파일(*.class) 로 생성된다.
             *
             *      Intent 라는 클래스에게
             *      java class 파일인 NewWordActivity.class 파일을 가져와서
             *      화면에 띄운다(class Loader).
             */
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
                .apply{
                    // 새로 열리는 Activity 에게 var HELLO = "반갑습니다" 처럼
                    // 변수를 만들어서 데이터를 전달하는 방법
                    putExtra("HELLO", "반갑습니다")
                    putExtra("NUM1", 3000)
                    putExtra("NUM2", 2000)
                }
            // getResultText.launch(intent)
            
            // 단순히 intent 에 설정된 대로 Activity 를 여는 방법
            startActivity(intent)
        }  // end addWord Click event

        val phoneCallBtn = findViewById<FloatingActionButton>(R.id.phone_call)
        phoneCallBtn.setOnClickListener{
            // Button 을 클릭하면 phoneCall Activity 가 화면에 나타나도록 세팅
            val intent = Intent(this@MainActivity, PhoneCall::class.java)
            startActivity(intent)
        }
    }
}