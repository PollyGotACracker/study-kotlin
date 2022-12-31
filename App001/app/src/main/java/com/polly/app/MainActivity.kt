package com.polly.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent.KEYCODE_ENTER
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    /**
     * main.xml 에 있는 2 개의 view 를 code 에서 사용하기 위한 객체 선언
     */
    // 자동 import: alt + enter
    private lateinit var textView : TextView;
    private lateinit var inputText : TextInputEditText;
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // layout 의 xml 구성파일을 직접 가져와서 화면을 구현하는 코드
        // R : res 폴더
        // R.layout : res 폴더의 layout
        // activity_main.xml 을 가져와서(읽어와, open) 하여
        // 처음 시작화면을 구성
        setContentView(R.layout.activity_main)
        
        // main.xml 에 설치된 2 개의 view 를 객체 변수에 할당(저장)
        textView = findViewById(R.id.text_view);
        inputText = findViewById(R.id.input_text);
        
        // 속성 setting: set**()
        // textView.setText("우리나라만세")
        textView.text = "우리나라 만세"

        // inputText.setOnKeyListener() :
        // 모든 키보드의 action 을 캡처하는 event 로
        // 최근 안드로이드에서
        // 한번 Enter(줄바꿈)을 입력하고 나면
        // 키보드가 작동하지 않는 버그 발견
        /**
         * xml 파일에서 input box 의 inputType = "text" 로 하면
         * 키보드에 줄바꿈이 아닌 "완성" Enter 가 나타난다.
         *
         * setOnEditorActionListener :
         * 키보드에서 완성 Enter 가 눌렸을 때 발생하는 Event Handler
         * 아래 코드는 Lambda 함수 방식으로 구현
         */
        inputText.setOnEditorActionListener{view,keyCode,event->
                // input box 에 입력된 문자열만 text 변수에 할당
                val text = inputText.text.toString()
                // Log.d : Console logcat 에 메시지 보이기(debug)
                Log.d("Main",text)
                // textView 에 표시하기
                textView.text = text
            // event 실행이 모두 완료됨을 알리기
            true
        }
    }
}