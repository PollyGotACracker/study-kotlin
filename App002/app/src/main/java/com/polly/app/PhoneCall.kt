package com.polly.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PhoneCall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_call)

        val txt_phone = findViewById<EditText>(R.id.txt_phone_number)
        val btn_call = findViewById<Button>(R.id.btn_call)
        val btn_phone = findViewById<Button>(R.id.btn_phone)

        btn_phone.setOnClickListener{
            // txt_phone_number 에 입력된 값 추출 후 String 으로 변환
            val phoneNumber = txt_phone.text.toString()
            // cf) URI 형태로 parsing. URI 가 아니라 Uri 임에 주의
            // URI 는 리소스(Resource)에 접근할 수 있는 유일한(Uniform) 식별자(Identifier)이다.
            // 가장 앞의 프로토콜(스키마)에 따라서, http:// 또는 https:// 로 시작하는 웹 주소뿐만 아니라,
            // 전화, 지도, 이미지, 텍스트 등 리소스를 로드한다. 여기서는 전화 프로토콜 tel: 을 사용한다.
            val phoneURI = Uri.parse("tel:${phoneNumber}")
            // cf) 암시적 인텐트
            // 특정 액티비티의 시작을 요청할 때, 수행될 액션과 수신 액티비티에 의해 처리되는 데이터 타입을 지정하는 방식
            // 특정 리소스의 URI 객체를 포함한 ACTION_... 액션 타입은
            // 해당 액션이 가능한 액티비티를 찾아 실행시킬 것을 안드로이드 시스템에 요청한다.
            val intent = Intent(Intent.ACTION_DIAL, phoneURI)
            startActivity(intent)
        }
        // ACTION_DIAL: 전화 앱을 열어 키패드에 전화번호 표시, 권한(permission) 필요 X
        // ACTION_CALL: 전화 앱을 열고 바로 전화 걸기, 권한 필요
        btn_call.setOnClickListener{
            /**
             * 안드로이드 전화 걸기
             * phone 기기에 기본적으로 내장된 전화걸기 서비스를 호출하여 전화 걸기
             * 호출하고자 하는 전화번호를 Uri 형태로 만들고,
             * Intent.ACTION_CALL intent 에게 전송하여 전화를 호출한다.
             * 이때, 시스템에 권한이 있어야 실제 전화를 걸 수 있다.
             *
             * 안드로이드 API 23 Level(마시멜로) 이상에서는
             * 권한을 부여할 것인지를 확인하는 절차가 반드시 필요하다.
             * 권한 부여 확인 후, 이를 승인하기 위하여 설정화면을 열고
             * 실제 권한 부여를 하는 코드가 필요하다.
             *
             * 여기에서는 권한 부여 확인 및 설정코드를 생략했다.
             * 이 경우 test 를 위하여
             * AVD 또는 연결한 기기에서 수동으로... 설정 > 앱 > 해당 어플 > 권한 > 전화 권한을 허용해준다.
             * 그리고 Manifest.xml 의 use-permission 항목에 CALL_PHONE 을 등록해야 한다.
             */

            /**
             * cf)
             * Kotlin String Template : $ 를 사용하여 변수의 값 출력
             * 변수명 바로 뒤에 이어 다른 문자열을 출력해야 하는 경우, 변수명을 중괄호로 감쌀 것
             * 중괄호 안에 if문 등의 식을 넣을 수 있음
             */
            val phone_number = txt_phone.text.toString();
            val phone_URI = Uri.parse("tel:$phone_number")
            val phoneIntent =  Intent(Intent.ACTION_CALL, phone_URI)
            startActivity(phoneIntent)
            /**
             * 안드로이드 시스템의 4가지 intent 컴포넌트
             * Activity Intent / Service / Broadcast Receiver / Content Provider 
             * 1. 액티비티 인텐트 : 개발자 자신의 어플에 생성한 Activity
             * 2. 서비스 : 백그라운드에서 실행되는 요소
             *          - 만약 자신의 어플에서 일정시간마다 알람을화면에 보이고 싶을 때,
             *          프로젝트의 Activity 를 server 로 등록한다.
             *          - 네트워크 서버와 연동하기도 한다.
             *          - 어플이 종료되어도 서비스는 강제종료되지 않는다.
             * 3. 브로드캐스트 수신자 : 안드로이드가 발송하는 여러가지 이벤트와 정보를
             *          받고, 작동하는 Activity
             *          - 브로드캐스트 발송자 : 안드로이드 OS
             * 4. 콘텐트 제공자 : 데이터를 관리하고 다른 애플리케이션의 데이터를
             *          제공하는 컴포넌트
             */
        }
    }
}