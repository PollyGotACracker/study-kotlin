package com.polly.hello

var intNum1: Int = 1000;  // 32bit, 2의 32승, -2의 31승 ~ 2의 31승 -1
var intNum2: Number = 1000;  // Int 와 Float 통합형
var longNum1: Long = 0L;  // 64bit, 2의 64승, -2의 63승 ~ 2의 63승
var shortNum1: Short = 0;  // 16bit
var byteNum1: Byte = 0;  // 8bit

var floatNum1: Float = 123.555F;  // 32bit, 소수점 이하 6자리
var doubleNum1: Double = 123.555;  // 64bit, 소수점 이하 14자리

fun add(): Float {
    return 123.555F + 123.333F;
}

fun main() {
    // 변수 type 이 다른 상태에서 서로 값을 할당하는 경우,
    // 특히 숫자일 경우 값을 잃거나 오차가 발생할 수 있기 때문에
    // 많은 주의가 필요하다.
    floatNum1 = intNum1.toFloat();
    intNum1 = doubleNum1.toInt();

    /**
     * add() 함수는 Float + Float 형 데이터를 return 하고 있다.
     * add() 함수가 return 하는 값을 변수에 받으려면
     * 받는 변수의 type 도 Float 형이어야 한다.
     */
    var ret: Float = add();
    println(ret);

    println(floatNum1);  // 1000.0
    println(intNum1);   // 123

    // 숫자가 클 때는 under-bar 로 분리할 수 있다.
    intNum1 = 1_000_000_000;
    longNum1 = 1_000_000_000_000_000L;

    var hexByte = 0xFF_77_BB;  // 16진수 표현
    var binByte = 0b0001_1100_0111;  // 2진수 표현

    println(hexByte);
    println(binByte);
}