package com.polly.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.polly.list.adapter.StudentRecyclerAdapter
import com.polly.list.databinding.FragmentMainListBinding
import com.polly.list.models.StudentModel

class MainListFragment : Fragment() {

    private lateinit var binding: FragmentMainListBinding
    private val stViewModel: StudentModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Adapter 와 ListView 를 연결
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // android:id="@+id/student_list"
        val recyclerView = binding.studentList
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = StudentRecyclerAdapter(stViewModel.studentList)
        recyclerView.adapter = adapter
    }
}