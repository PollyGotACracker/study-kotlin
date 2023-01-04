package com.polly.game.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polly.game.data.allWordsList

// base-package 폴더(com.polly.game) 마우스 우클릭 > package
// data 폴더 마우스 우클릭 > Kotlin Class / File
/**
 * 클래스를 만들 때 이름 부여 규칙
 * 첫 글자는 영문 대문자
 * 두 번째부터는 영문 대소문자, 숫자, Under bar_ 등 사용 가능
 * 가급적 2단어 이상을 조합하여 명명
 * Under bar 를 사용하기보다는 CamelCase 형식으로 명명을 한다.
 *
 * ---ViewModel 클래스는 lifecycle 의 ViewModel 클래스를
 * 상속받아서 작성한다.
 */
class WordViewModel : ViewModel() {
    // viewModel 을 통해서 Observer 할 변수 선언
    /**
     * _engWord : String type 의 데이터를 저장하는 변수이고
     * Observer 를 통해서 변화를 감시할 수 있는 state
     * private 으로 기본 변수를 선언한다.
     */
    private var _engWord = MutableLiveData<String>("")

    /**
     * engWord : viewModel 에서 사용되는 변수를 외부에서 읽기 참조할 수 있도록
     * getter method 를 선언해둔다.
     */
    val engWord: LiveData<String> get() = _engWord

    /**
     * 외부에서 engWord 변수에 접근하여 데이터를 저장하는 함수
     */
    fun setEngWord(word: String) {
        _engWord.value = word
    }

    private var _currentWord = MutableLiveData<String>("")
    val currentWord: LiveData<String> get() = _currentWord
    init {
        nextWord()
    }

    fun nextWord() {
        // allWordsList 는 data > LoadData.kt 에서 지정됨
        // 영문단어를 char(문자) 배열로 변경하고
        val rndString= allWordsList.random().toCharArray()
        // 무작위로 shuffle() 하기, rndString 데이터 자체가 변경
        rndString.shuffle()
        // char 배열을 문자열(String) 으로 변환시키기
        // _currentWord.value = String(rndString)
        
        // 구분자로 공백 추가
        _currentWord.value = rndString.joinToString(separator = " ")
    }

}