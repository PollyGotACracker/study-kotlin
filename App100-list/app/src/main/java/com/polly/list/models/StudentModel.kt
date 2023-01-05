package com.polly.list.models

import androidx.lifecycle.ViewModel
import com.polly.list.data.studentStringList

// 4는 반이므로 제외
const val ST_NUM = 0
const val ST_NAME = 1
const val ST_DEPT = 2
const val ST_GRADE = 3
const val ST_ADDR = 5
const val ST_TEL = 6

class StudentModel : ViewModel() {

    /**
     * List<type> 데이터 : 요소를 추가 삭제할 수 있는 배열
     * MutableList<StudentDto> : StudentDto type 의 데이터만 저장할 수 있는 배열 생성
     */
    val studentList: MutableList<StudentDto> = mutableListOf()

    init {
        getStudentList()
    }

    /**
     * 콜론 (:) 구분자로 구분된 데이터 문자열을 분해하여
     * StudentDto 객체로 만들고
     * 객체를 studentList 로 변환하는 함수
     */
    private fun getStudentList() {
        studentStringList.forEach {
            // split(구분자) : 문자열을 구분자로 분해하여
            // 배열로 만들어주는 함수
            val items: List<String> = it.split(':')
            // Logcat 에 Log 띄우기...
            // com.polly.list / Debug / Model
            // Log.d("Model", items[1])

            // 분해된 문자열 각 요소의 데이터를 갖는 student 객체 생성
            val student = StudentDto(
                num = items[ST_NUM],
                name = items[ST_NAME],
                dept = items[ST_DEPT],
                grade = items[ST_GRADE].toInt(),
                address = items[ST_ADDR],
                tel = items[ST_TEL],
            )
            studentList.add(student)
            // studentList.add("Korea") : data type 이 다르므로 add 불가
        }
    }

}