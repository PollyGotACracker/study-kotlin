package com.polly.hello

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.polly.hello.databinding.ActivityMainBinding

/**
 * class 는 Kotlin 에서 사용하는 모듈 구조
 * class 는 객체지향 프로그래밍의 기본 모듈 단위이다.
 * 객체지향 프로그래밍에서는 다른 클래스의 기능을 상속 확장(Extends)하여
 * 일부 기능을 별도로 구현할 수 있다.
 */
class MainActivity : AppCompatActivity() {


    /**
     * lateinit: 늦은 초기화
     * Kotlin 에서는 변수를 선언하면서 초기화(값 할당)하는 것이 원칙이다.
     * 그런데 안드로이드 등의 어플을 만들 때는 아직 변수를 초기화할 수 있는 도구가
     * 만들어지기 이전일 경우가 있다.
     * 이때는 lateinit var 키워드를 사용하여
     * 변수 초기화를 잠시 미룰 수 있다.
     * (mutable 변수만 가능하므로 var 키워드만 사용)
     *
     * MainActivity.kt - activity_main.xml
     * ActivityMainBinding : res -> layout -> activity_main.xml
     */
    // class 는 PascalCase 로 선언한다.
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    /**
     * override fun
     * MainActivity 가 상속받은 AppCompatActivity (부모)클래스에서 정의해놓은 함수
     * 부모 클래스에서 정의해놓은 함수를
     * 자식 클래스에서 다시 재정의하여 확장하는 것: override
     *
     * 원래의 onCreate() 함수를 확장하여
     * 내 App 에서 작동되는 코드를 추가하기 위함
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // AppCompatActivity 에 정의된 원래 onCreate 함수를 호출하여
        // 기본 설정을 마치고
        super.onCreate(savedInstanceState)

        // 내가 만든 App 의 기능을 추가하겠다.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, R.string.hello, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}