package com.polly.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/**
 * class : 객체지향 프로그래밍(OOP)에서 모듈의 기본 단위
 *
 * Kotlin 은 class 모듈이 필수 조건은 아니지만
 * 모듈에 class 를 사용하는 이유는
 * 이미 제공해주는 라이브러리의 다른 class 의 기능을
 *      상속받아 사용해야 하기 때문에
 * 이때는 모듈이 반드시 class 로 되어있어야 한다.
 *
 * class 상속(class 의 inheritance;Extends)
 *  이미 잘 만들어진 class 모듈의 기능을 그대로 이어받아 사용하는 방법
 *  이어받은 기능에 나만의 코드를 추가하거나, 기존의 코드를 확장하여 사용
 *
 * 상속은 기존 코드의 복사 붙이기 와는 완전히 다른 차원의 개념이다.
 * 상속은 기존 코드를 변경 없이 내 프로젝트에 그대로 적용할 수 있고,
 *      만약 기존 코드가 확장(Upgrade)되면, 프로젝트에 적용된 코드도
 *      자동으로 확장(Upgrade) 된다.
 *      
 * 캡슐화, 추상화
 * 상속을 받는 곳에서는 기존의 부모 코드(Parent Class)가 어떻게 작동되는지
 *      완전하게 이해하지 않아도 내 프로젝트에 적용할 수 있다.
 *      즉, 기존 부모 코드를 사용하는 방법만 알면 내 프로젝트에 적용할 수 있다.
 *
 * 객체지향 개념에서는 기존의 코드를 재사용하는 것이 가장 중요한 부분이다.
 */
class MainActivity : AppCompatActivity() {

    /**
     * onCreate() 함수
     * 보통 class 내부에 선언된 함수는 method 라고 부른다.
     * 함수를 호출할 때는 함수이름() 형식으로 사용하는 반면,
     * method 는 객체.함수이름() 형식으로 사용한다.
     * 객체는 클래스를 구체적으로 사용가능한 변수로 만들어진 것
     *
     * 이 method 에는 override fun 이라는 키워드가 있는데
     * 이 method 는 원래 AppCompatActivity class 에 정의(선언)되어 있는
     *  method 이다. 이 method 를 자신의 App 프로젝트에서
     *  다시 코드를 작성하여 자신의 App 이 작동되도록 만드는 것이다.
     * 이것을 method 의 재정의(override)라고 한다.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // super 객체의 onCreate() method 를 호출(사용, 실행)하는 코드
        // super 객체는 AppCompatActivity 클래스를 가리키고 있다.
        super.onCreate(savedInstanceState)
        // 우리 App 프로젝트를 작동시키는 코드의 시작부분
        // res / layout / activity_main.xml 파일을 읽어와서 화면을 그려라.
        // 모든 resource 는 R 클래스로 컴파일
        // 레이아웃 리소스는 R 클래스 내부의 layout 이라는 서브 클래스로 포함
        setContentView(R.layout.activity_main)
        
        // activity_main.xml 에 만들어진 TextView 와 Button (tag)을 코드에서 사용하기
        // layout.xml 에 설정된 도구들은 모두 view 로 칭한다.
        // 일부에서는 컴포넌트, 위젯이라고 하기도 한다.
        // 이 뷰를 코드에서 사용할 때 View Class Type 이라고 한다.
        // Type(형) : 변수를 선언하는 일종의 키워드처럼 작동되는 것
        // TextView type 의 변수를 선언하고
        // main.xml 에 설정된 txt id 의 view 를 가져와서 변수에 할당(저장, 보관)
        val txt1: TextView = findViewById(R.id.txt1)
        // findViewById 에게 지금 R.id.txt1 은 TextView type 의 view 라는 것을 알려주고
        // 가져온 값을 txt11 에게 할당
        // Generic type(<Type>)으로 지정하기
        val txt11 = findViewById<TextView>(R.id.txt1)
        var btnClick1 = findViewById<Button>(R.id.btn_click1)
        
        // TextView 에 보여지는 text 를 "대한민국만세" 로 변경
        txt1.text = "대한민국만세"

        // btnClick1 을 터치(클릭)하면 화면에 안내 메시지를 보여주기
        // setOnClickListener( { Callback } ) 에서 소괄호 생략
        // setOnClickListener( { it -> { Callback } } )
        // it 이라는 기본 매개변수 생성(JS eventListener 의 event 와 유사)
        btnClick1.setOnClickListener{
            // Toast Message
            // 잠시 안내 메시지를 보여주고 사라지는 alert
            // Toast class 의 makeText() 함수 사용
            Toast
                .makeText(
                    this@MainActivity,  // 어떤 화면(어디에서)?
                    "나는 토스트",  // 어떤 메시지(무엇을)?
                    Toast.LENGTH_LONG)  // 몇 초 동안(얼마동안)?
                .show()  // 생성된 Toast 를 실행하기

            Snackbar
                .make(
                    it,  // 어디에, 자동으로 Callback 함수의 매개변수로 설정되어 있다.
                    "나는 스낵바",  // 무엇을
                    Snackbar.LENGTH_LONG)  // 얼마동안
                .show()  // 생성된 Snackbar 를 실행하기
        }  // end btnClick1 Click event
        /**
         * cf)
         * Dialog
         * 간단한 정보를 보여주고 사용자의 선택 또는 입력을 요구하는 대화상자
         * 다른 행위를 하지 못하게 막기 때문에 confirm/prompt 팝업과 유사
         *
         * Toast
         * 작은 팝업 형태로 사용자의 동작에 대한 단순 피드백 전달
         * 시간이 지나면 자동으로 사라지나, 사용자가 직접 닫을 수 없음
         * 사용자와 상호작용 할 수 없음
         * activity 와 연결
         *
         * Snackbar
         * 화면 하단에서 사용자의 동작에 대한 단순 피드백 전달
         * 시간이 지나면 자동으로 사라지며, 사용자가 직접 닫을 수 있음
         * 버튼을 통한 간단한 상호작용 가능(닫기, 취소 등)
         * view(it) 와 연결
         */

        val btnClick2 = findViewById<Button>(R.id.btn_click2)
        // 변수의 scope
        // count 함수는 ClickEvent 밖에서 선언되었기 때문에
        // App 이 작동되는 동안 변화된 값을 그대로 유지하고 있다.
        // ClickEvent 입장에서는 부모 scope 의 변수 라고 한다.
        // MainActivity.onCreate() 함수를 scope 로 갖는 변수이다.
        var count = 0;
        btnClick2.setOnClickListener{
            count++
            // sum 변수는 setOnClickListener 함수 scope 변수이다.
            // 함수가 시작될 때 새롭게 만들어지고,
            // 함수가 작동이 끝나면 변수는 소멸된다.
            var sum = 0;
            sum++
            txt1.text = "$count ... $sum"
        }  // end btnClick2 Click event

        val btnClick3 = findViewById<Button>(R.id.btn_click3)
        /**
         * 안드로이드에서 여러 화면을 번갈아가며 정보를 보여주는 방법
         * 1. Activity 를 여러 개 만들어서 전환하며 보여주는 방법
         * 2. Fragment 를 여러 개 만들어서 전환하며 보여주는 방법
         * 
         * Activity 에 비해 Fragment 는 화면을 전환하는 데 리소스 절약
         * 최근 안드로이드에서 많이 사용하고 권장하는 방법
         * 그러나 Activity 에 비해 Fragment 의 화면을 전환하는 것은
         *      초기 설정이 다소 까다롭다.
         *
         * 여기서는 Activity 전환을 사용하여 MainActivity 에서
         * NewActivity 를 열고 위로가기(뒤로가기) 기능을 구현한다.
         *
         * Activity 를 사용하여 화면을 전환할 때는
         * 새로운 Activity 를 intent 로 만들고 startActivity() 함수에 전달해주면
         * 간단하게 화면이 전환된다.
         */
        btnClick3.setOnClickListener{
            // Intent 클래스를 사용하여 새로운 intent 객체 변수 생성
            // 현재 Activity(this@MainActivity) 에서
            // 새로운 Activity 를 구현한 class 파일을 Loading 하여
            // newActivityIntent 객체 할당하기
            val newActivityIntent = Intent(
                this@MainActivity,  // 어디에서
                NewActivity::class.java  // 누구를
            ).apply{
                // 새로운 Activity 에게 어떤 값을 전달하고자 할 때
                // username 이라는 변수를 생성하고 polly 라는 문자열을 담아서 전달
                // 어떤 데이터 형식이든 담을 수 있다.
                putExtra("username","polly")
                putExtra("age",100)
            }
            startActivity(newActivityIntent)
        }

        val btnClick4 = findViewById<Button>(R.id.btn_click4)
        btnClick4.setOnClickListener{
            val number1 = findViewById<EditText>(R.id.number1).text.toString()
            val number2 = findViewById<EditText>(R.id.number2).text.toString()
            val addActivityIntent = Intent(
                this@MainActivity,
                AddActivity::class.java
            ).apply{
                putExtra("number1", number1.toInt())
                putExtra("number2", number2.toInt())
            }
            startActivity(addActivityIntent)
        }
        // 뒤로가기 버튼 생성 및 label 변경
        // manifests -> AndroidManifest.xml 파일에서
        //        <activity
        //        android:name=".NewActivity"
        //        android:parentActivityName=".MainActivity"
        //        android:label="@string/new_activity_label"
        //        ...
        //        </activity>

    }
}