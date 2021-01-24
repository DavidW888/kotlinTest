package com.example.mykotlin.demo4

import android.view.GestureDetector

fun main(args: Array<String>) {

    //kotlin的数组不支持协变，而java的数组是支持协变的
    val array= arrayOf(1,2,3)

   // val numberArray:Array<Number> = array  报错
    val testJava = Test()
    val numberArray: Array<Int>? =testJava.integers
    if (numberArray != null) {
        numberArray[numberArray.size-1] =5
        for (index in numberArray){
            println(index)
        }
    }

    //kotlin里面的list是支持协变的 因为只读没有写入的安全问题
    val intList = listOf<Int>(1,2,3)
    val numList:List<Number>  = intList
    for (index in numList){
        println("$index 的类型是${index.javaClass.canonicalName}")
    }
    println("---------------------------")
    //kotlin里面的MutableList 是不支持协变的 相当于java中的list
    val intMulList:MutableList<Int> = MutableList<Int>(3){index -> index+1 }
   // val numMulList:MutableList<Number> = intMulList 报错 类似于java的 list 不支持协变
    val numMulList:MutableList<in Int> = intMulList
    numMulList.add(6)
    for (index in numMulList){
        println("$index")
    }


    //问题1
    val fatherArray:Array<Father> = arrayOf(Father())
        for (father in fatherArray){
            father.meth()
    }

    Test1<Son>().fill(fatherArray, Son())
    fatherArray[0].meth()


    //问题2
    val sonList:Array<Son> =Array(2){ Son()}

    val fatherList:Array<Father> = Array(2){ Father() }

    Test2<Father>().copy(fatherList,sonList)

    for(index in fatherList){
        index.meth()
    }






}

//1,实现一个 fill 函数，传入一个 Array 和一个对象，将对象填充到 Array 中，要求 Array 参数的泛型支持逆变（假设 Array size 为 1）。
class Test1<T>{
    fun fill(array:Array<in T>,any:T){
        if(array.size==1){
            array[0] = any
        }

    }
}

class Test2<T>{

//2,实现一个 copy 函数，传入两个 Array 参数，将一个 Array 中的元素复制到另外个 Array 中，要求 Array 参数的泛型分别支持协变和逆变。
// （提示：Kotlin 中的 for 循环如果要用索引，需要使用 Array.indices）
    fun copy(toArr :Array<in T>,fromArr :Array<out T>){
        if(fromArr.size==toArr.size){
            for (index in fromArr.indices){
                toArr[index] = fromArr[index]
            }
        }


    }
}

open class Father{
    open  fun meth(){
        println("这是father的方法")
    }
}

class Son :Father(){
    override fun meth() {
        println("这是son的方法")
    }
}

