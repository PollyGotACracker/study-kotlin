package com.polly.student.data


// Kotlin 에서는 data class 를 생성하면 여러 메소드가 자동으로 함께 생성되어,
// 클래스로 객체 생성 시 편리하게 사용할 수 있다.
// : hasCode(), copy(), equals(), toString(), componentsN()

// 반드시 ( header ) 기본 생성자 파라미터를 var, val 로 선언해주어야 한다.
// { body } 에 추가적으로 코드를 작성할 수 있다.
data class Student(
    val stNum : String? = null,
    val stName : String? = null,
    val stDept : String? = null,
    val stGrade : Int? = null,
    val stTel : String? = null,
    val stAddr : String? = null,
)
