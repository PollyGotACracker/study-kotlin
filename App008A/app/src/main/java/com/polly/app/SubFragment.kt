package com.polly.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.polly.app.databinding.FragmentMainBinding
import com.polly.app.databinding.FragmentSubBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SubFragment : Fragment() {

    /**
     *  실제 binding 된 view 가 저장될 _binding 변수와
     *  binding get() : _binding 데이터를 읽기 위한 getter 함수 선언
     *  ...? = null : fragment 에서 메모리 누수를 방지하기 위한 설정
     *  (onDestroyView() 에서 _binding 을 null 처리)
     */
    private var _binding : FragmentSubBinding? = null
    // _binding!! : _binding 이 null 일 경우 exception 처리하라
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSubBinding.inflate(inflater,container,false)
        /**
         * _binding 객체를 직접 접근하여 데이터를 참조하지 않고
         * binding getter 함수를 통하여 간접 접근
         * 위에서 binding get() 함수를 선언할 때
         *      _binding!! 을 참조하도록 만들었기 때문에
         *      번거롭게 !! 를 사용하지 않아도 된다(선언 이후 binding!!... 하지 않아도 된다).
         * binding 에 접근을 하면 그때마다 _binding 으로부터
         * 데이터를 가져와서 참조할 수 있도록 만들어준다.
         * 이러한 동작을 getter method 라고 한다.
         */
        val root = binding.root

        val txtView = binding.txtView
        txtView.setOnClickListener{
            findNavController().navigate(R.id.action_subFragment_to_mainFragment)
        }

        // by navArgs() : navArgs() 함수를 lazy 로 호출하여(화면이 다 그려진 다음 호출;지연호출)
        // args 값을 찾기
        val args : MainFragmentArgs by navArgs()
        // args.변수 값을 getter 하여 txtView 의 text 속성에 setting
        txtView.text = "${args.word}"

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_sub, container, false)
        return root
    }
}