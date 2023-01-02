package com.polly.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.polly.app.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputAdd.setOnEditorActionListener {view, _, _ ->
            val voca = binding.inputAdd.text.toString()
            lateinit var message:String
            var ret = true;
            if(voca.isNullOrEmpty()) {
                ret = false;
                Snackbar.make(view, "단어를 입력해주세요", Snackbar.LENGTH_LONG).show()
            }
            if(ret){
                val mainIntent = Intent(this@AddActivity, MainActivity::class.java)
                    .apply {
                        putExtra("voca",voca)
                    }
                startActivity(mainIntent)
            }
            /**
             * setOnEditorActionListener 의 옵션...
             * input box 의 키보드가 보이는 상태에서
             * Snackbar 를 보이면 키보드에 가려져서 Snackbar 가 보이지 않기 때문에
             * 마지막의 값을 false 로 해주면 키보드가 자동으로 사라진다.
             */
            ret
        }

    }
}