package com.polly.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.polly.app.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    // cf) 소괄호 안에 각 인자의 데이터타입, 바깥쪽에 반환값의 데이터타입 표시
    private fun checkVal(it:View):Boolean {
        var value = binding.inputAdd.text.toString()

        // cf) 조건문의 각 block 에서 데이터타입에 맞는 return 을 마지막에 반환할 경우,
        // 각각 return 문을 넣지 않고 return if...else 로 축약할 수 있다.
        return if (value.isNullOrEmpty()) {
            Snackbar.make(it, "단어를 입력하세요", Snackbar.LENGTH_LONG).show()
            false
        } else {
            val action = MainFragmentDirections.actionMainFragmentToResultFragment()
            action.voca = binding.inputAdd.text.toString()
            findNavController().navigate(action)
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val root = binding.root

        // cf) 전달하고자 하는 값을 변수로 선언할 경우,
        // 반드시 EventListener 의 안에서 해야 값이 정상적으로 전달된다.

        // cf) setOnEditorActionListener 에서 View 는 첫 번째 매개변수임
        binding.inputAdd.setOnEditorActionListener {view, _, _ ->
            checkVal(view)
        }
        // cf) setOnClickListener 에서 it(=View) 은 매개변수가 아님
        binding.btnAdd.setOnClickListener {
            checkVal(it)
        }

        return root
    }
}