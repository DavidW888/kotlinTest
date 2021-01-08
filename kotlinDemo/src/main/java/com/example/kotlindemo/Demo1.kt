package com.example.kotlindemo


//第一个kotlin小程序
fun main(args: Array<String>) {
    /* println("Hello Kotlin");
     val num = add(1, 2)*//*我是注释里面的注释*//*
    print("两数相加的和为$num")*/
    // meth()
//    println(getStringLenght("aaa"))
//    print(getStringLenght(11))
   // getIndex()
//    println(  describe(1))
//    println(  describe( "Hello1" ))
//    println(   describe( 100L ))
//    println( describe( 100.0))
//    for (x in 1..10 step 2) { print(x) }
//    for (x in 9 downTo 0 step 3) { print(x) }
//    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
//    fruits .filter { it.startsWith("a") }
//        .sortedBy { it }
//        .map { it.toUpperCase() }
//        .forEach { println(it) }

}

//两数相加
fun add(a: Int, b: Int): Int {
    return a + b
}

//val 与var
val a: Int = 1
var b = 5
fun meth() {
    // a=2; val 不能被再次修改
    b = 6
    print("b的值为$b")
}

// 返回可空的类型
fun parseInt(str: String): Int? {
    return null
}

//is 运算符后 代码不需要转换
fun getStringLenght(obj: Any): Int? {
    if (obj is String)
        return obj.length
    return null
}

//for循环
val items = listOf("apple", "banana", "kiwifruit")
fun getIndex() {
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

//when表达式
fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "Unknown"
}

//range范围
val x =1
val y=10
fun isRange(x:Int):Boolean{
    return x in 1..10

}
