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
        // <FloatingActionButton> 으로 설정한 type 과
        // R.id.add_word 로 선택된 대상의 type 이 일치하지 않으면 컴파일 오류가 난다.
        // <> 사이에 type 을 명시하는 것을 Generic 설정이라고 한다(Generic type).

        // activity_main.xml 파일의 add_word 라는 id 를 가진
        // FloatingActionButton 인 View(Widget;Component)를 변수로 선언
        // document.querySelector() 와 유사
        val addWord = findViewById<FloatingActionButton>(R.id.add_word)
        // Button 을 클릭하면 intent 객체 생성 후 activity 열기(화면 전환)
        // cf) activity : 앱의 기능을 갖는 단일의 독립 실행형 모듈(컴포넌트)로 사용자 인터페이스 화면 및 그 기능과 연관
        // cf) intent : 하나의 activity 가 다른 activity 를 launching 하는 메커니즘
        addWord.setOnClickListener{

            /**
             * MainActivity 에서 다른 Activity 화면 열기(Activity 전환)
             *
             * NewWordActivity::class.java
             *      Kotlin 으로 작성한 class 파일(*.kt, 소스코드)은
             *      컴파일이 된 후 java class 파일(*.class)로 생성된다.
             *
             *      Intent 라는 클래스에게
             *      java class 파일인 NewWordActivity.class 파일을 가져와서
             *      화면에 띄운다(class Loader).
             */
            // cf) 명시적 인텐트
            // 특정 액티비티의 시작을 요청할 때, 시작될 액티비티의 클래스 이름(컴포넌트 이름)을 참조하는 방식
            // 이때 Intent 클래스의 객체 인스턴스 생성
            //
            // this@THISActivity : 현재 activity 를 this 로 지정
            // NEXTActivity::class.java : 다음 activity 를 java class 파일로 생성
            // apply() : 함수를 호출한 수신(receiver) 객체를 this 로 반환(this 는 Intent)
            //         apply 대신 변수를 이용하여 intent.putExtra() 가능
            // Intent 객체의 Extras 속성(attribute)은 데이터를 저장하는 Bundle 객체이다.
            // putExtra() : Intent 를 통하여 다음 Activity 로 데이터 전달 <> getExtras
            //              Bundle 객체 생성 후 2개의 인자를 키-값 쌍의 형태로 저장하는 함수
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
            // 생성한 intent 객체를 인자로 전달
            startActivity(intent)
        }  // end addWord Click event

        val phoneCallBtn = findViewById<FloatingActionButton>(R.id.phone_call)
        phoneCallBtn.setOnClickListener{
            val intent = Intent(this@MainActivity, PhoneCall::class.java)
            startActivity(intent)
        }
    }
}