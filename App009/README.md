# Android viewModel 데이터 관리

* 안드로이드 App 에서는 Kotlin Jet-pack Compose 에서 제공하는 `viewModel` 을 사용하여  
데이터(단일변수, 배열, 객체 등)를 화면에 표현하는 방법을 구현한다.

## viewModel 이란
* App 에서 사용하는 데이터를 `viewModel` 이라는 `Observer` 가 변화되는 데이터를 감시하고 있다가,  
데이터에 변화가 발생하면 변화된 데이터를 UI 화면에 반영해주는 기술적 메커니즘
* 다른 도구(React) 에서 사용하는 state 라는 개념과 유사하다.

## viewModel 을 사용하기 위한 dependencies 설정
* Maven Repository 에서... : 
* Android lifecycle 검색 ->
* Android Lifecycle ViewModel
* Android Lifecycle LiveData
```agsl
def lifecycle_version = "2.5.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
```
* Fragment 에서 LiveData 를 사용하기 위한 dependency
* Android Fragment 검색 ->
* Fragment Kotlin Extensions
```agsl
implementation 'androidx.fragment:fragment-ktx:1.5.5'
```

* view 와 viewModel 을 실시간으로 연결하기 위한 Observer 보조 도구
* android data binding 검색 ->
* DataBinding Runtime
```agsl
implementation 'androidx.databinding:databinding-runtime:7.3.1'
```
* dependencies 를 설정한 후 메뉴의 `File / Project Structure / Suggestion` 확인하여 버전 확인