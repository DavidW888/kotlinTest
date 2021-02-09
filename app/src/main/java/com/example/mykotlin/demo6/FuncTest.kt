package com.example.mykotlin.demo6

import java.io.File

fun foo(bar :Int) {
     print(bar)
 }

 val bar =::foo

//函数的声明
fun testBar(bar : (Int) -> Unit){
    bar.invoke(1)
}

class FuncTest{
    fun testBar(bar :String){
    }
}

fun main(args: Array<String>) {
   // bar(1)
    testBar(bar)
    //函数的引用
    val string = FuncTest::testBar
    val funcTest = FuncTest()
    val funString = funcTest::testBar

    fun mutiRetureTest() :Triple<Int,Long,Double>{
        return Triple(1,2L,3.0)
    }

    val(a,b, c) = mutiRetureTest()
    val dd = a + b
    val gg = b + c
    println("dd是$dd , gg是$gg")

    //默认函数值
    defaultTest(1)
    defaultTest(b="YYY")


    listOf(1,2,3).map{
        print(it)
    }

    FuncTest().let(::print)
    val f =FuncTest().apply (::print)

    File("build.gradle").readText().toCharArray().filterNot { it.isWhitespace() }.groupBy { it }
            .map{ it.key to it.value.size}.let(::println)

}

fun defaultTest(a :Int=1 ,b :String ="xxx",c:Double= 3.0){
    println("a是$a , b是$b, c是$c")
}