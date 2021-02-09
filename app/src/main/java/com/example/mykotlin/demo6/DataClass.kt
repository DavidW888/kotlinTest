package com.example.mykotlin.demo6


class Person(){

}

data class DataClass(val a:Int,var  b:String ,val person:Person)

//data 修饰的类被定义为final所以不能被继承
//class MyDataClass :DataClass(1,"2",Person()){
//
//}

fun main(args: Array<String>) {
    val dataClass = DataClass(1,"xxx" , Person())
    dataClass.a
    dataClass.component1()

}