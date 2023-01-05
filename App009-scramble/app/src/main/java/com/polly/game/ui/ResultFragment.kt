package com.polly.game.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.polly.game.MainActivity
import com.polly.game.R
import com.polly.game.databinding.FragmentResultBinding
import com.polly.game.models.WordViewModel

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val wordViewModel: WordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }  // end CreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.wordViewModel = wordViewModel

        val inputText = wordViewModel.inputWord.value.toString()
        val unscrambleText = wordViewModel.unscrambleWord.value.toString()

        // 다음의 코드는 DataBinding 을 수행함으로써 의미없는 코드가 된다.
        // val word = binding.txtInputWord.text.toString()
        // wordViewModel.inputWord.value = word

        /**
         * if( 문자열1.equals(문자열2) )
         * if( 문자열1 == 문자열2 ) 를 실행하는 코드이다.
         * 숫자형 변수일 경우 if( 숫자1 == 숫자2 ) 결과가 항상 true, false 가 된다.
         *
         * 하지만 문자열일 경우 문자열을 생성하는 방법에 따라
         * if ( 문자열1 == 문자열2 ) 연산이 정확한 true, false 결과를
         *      보여주지 않을 때가 있다(값의 저장방식에 따라...).
         *
         * 그래서 Java, Kotlin 에서는 문자열의 같음을 비교할 때
         * ==(동일 연산자)를 사용하지 말고 문자열.equals() 함수를 사용하여
         * 연산 처리를 하도록 한다.
         *
         * 또한 이 함수를 사용하면
         * 영문자일 경우 대소문자 구분 없이(true),
         * 대소문자를 정확히 구분하여(false) 의 경우를 지정하여
         * 문자열을 비교할 수 있다.
         */

        // equals() : 문자열 또는 객체 대상으로 사용하는 함수
        // 옵션은 대소문자 무시 여부(ignoreCase)
        // 비교연산자 방식 사용하지 말 것

        val oldScore = wordViewModel.gameScore.value!!.toInt()
        val oldCount = wordViewModel.gameCount.value!!.toInt()

        if(inputText.equals(unscrambleText,true)) {
            setTextField(true)
            // 점수 증가하기
            wordViewModel.gameScore.value = oldScore + 1
            if(wordViewModel.gameScore.value!!.toInt() >= 10) {
                binding.txtResult.text = getString(R.string.wow)
            }
        } else {
            setTextField(false)
        }
        wordViewModel.gameCount.value = oldCount + 1
        binding.txtGameCount.text = getString(R.string.game_count, wordViewModel.gameCount.value!!.toString())
        binding.txtGameScore.text = getString(R.string.game_score, wordViewModel.gameScore.value!!.toString())

        wordViewModel.nextWord()

        binding.btnReturn.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.changeFragment(FRAGMENT_MAIN)
            wordViewModel.inputWord.value = null
        }

    } // End onViewCreated

    private fun setTextField(correct : Boolean) {
        if (correct) {
            binding.txtResult.text = getString(R.string.correct)
        } else {
            binding.txtResult.text = getString(R.string.incorrect, wordViewModel.unscrambleWord.value.toString())
        }
    }
}