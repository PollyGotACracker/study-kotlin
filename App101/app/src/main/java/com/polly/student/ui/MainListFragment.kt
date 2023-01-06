package com.polly.student.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.polly.student.adapter.StudentRecyclerAdapter
import com.polly.student.databinding.FragmentMainListBinding
import com.polly.student.models.StudentViewModel


class MainListFragment : Fragment() {
    private lateinit var binding : FragmentMainListBinding
    private val studentViewModel : StudentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainListBinding.inflate(inflater,container,false)
        return binding.root
    }

//        binding.studentList.layoutManager = LinearLayoutManager(context)
//        binding.studentList.adapter = studentAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * cf) with 함수
         * 객체를 인자로 받고, 그 프로퍼티에 직접 접근할 수 있음
         * non-null 객체 사용, return 불가
         */
        val studentAdapter = StudentRecyclerAdapter(studentViewModel.studentList)
            with(binding.studentList){
                layoutManager = LinearLayoutManager(context)
                adapter = studentAdapter
            }

        studentViewModel.studentList.observe(
            viewLifecycleOwner,
            Observer{studentAdapter.modifyNotice()}
        )

        // floating button 을 클릭하면 임의 학생정보를 배열에 추가하기
        binding.btnAdd.setOnClickListener {
            studentViewModel.add()
        }
    }
}