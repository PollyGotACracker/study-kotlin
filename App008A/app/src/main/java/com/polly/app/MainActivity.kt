package com.polly.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.polly.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    // view Binding 을 활성화하여 사용하기 위한 객체 선언
    // Kotlin 은 변수를 선언함과 동시에 초기화(값 할당) 하는 것이 원칙이다.
    // 하지만 경우에 따라 선언과 초기화를 분리시켜야 할 때도 있다.
    // lateinit var 키워드를 사용하여 변수를 선언한다.
    private lateinit var binding: ActivityMainBinding
    private lateinit var appbarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // binding 을 사용하기 위하여 초기화(값 할당)하기
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)

        // fragment_layout.xml 에 있는 FragmentContainerView 를 가져와서
        // navController 로 생성하기
        val navController = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
            ?.findNavController()

        appbarConfig = AppBarConfiguration(navController!!.graph)
        setupActionBarWithNavController(navController!!,appbarConfig)
    } // end onCreate

    override fun onSupportNavigateUp(): Boolean {

        val navController = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)?.findNavController()

        // Appbar 의 up(위로가기, 뒤로가기 <-) 버튼 활성화
        return navController!!.navigateUp(appbarConfig)
                || super.onSupportNavigateUp()

        // return super.onSupportNavigateUp()
    }
}