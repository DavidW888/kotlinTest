package com.example.kotlindemo.basekotlin

import java.io.InputStream
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths


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
    //创建kotlin对象  使用let以及apply
//    val kotlinData =KotlinData()
//    println(kotlinData.age)
//    println(kotlinData.let<KotlinData, Newtest> {
//
//        it.age = 111;
//        it.name = "xxx"
//        val test = Newtest();
//        test.age = 111;
//        test.name = "xxx"
//        test
//
//    }.age)
//
//    println( kotlinData.apply {
//        age=88
//    }.age)


//    val myTurtle = Turtle()
//    with(myTurtle) {
//        penDown()
//        for (i in 1..4) {
//            forward(100.0)
//            turn(90.0)
//        }
//        penUp()
//    }
//    val stream = try {
//        Files.newInputStream(Paths.get("/some/file.txt"))
//    } catch (e: Exception) {
//         e
//    }
//    if(stream is InputStream){
//        stream.buffered().reader().use { reader -> println(reader.readText()) }
//    }else{
//        print("测试")
//    }
//
//    //两个数的交换
//    var a = 1
//    var b = 2
//    a=b.also { b = a }
//
//    println("a的值为:$a,b的值为:$b")
    // calcTaxes()

//    val a = """if(a > 1) { | return a |}""".trimMargin()
//    print(a)

//    for (i in 1..5) {
//        loop@ for (j in 1..4) {
//            if (j==3) break@loop
//            println(j)
//        }
//    }

    foo()
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3)
            return@lit
        else
            print(it)
    }
    print(" done with explicit label")
}// 局部返回到该 lambda 表达式的调⽤者，即 forEach 循环 }

fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}

class Newtest {
    var age: Int? = null
    var name: String? = null


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
val x = 1
val y = 10
fun isRange(x: Int): Boolean {
    return x in 1..10

}
