package com.example.mykotlin.demo2

//1,创建一个 Kotlin 类，这个类需要禁止外部通过构造器创建实例，并提供至少一种实例化方式。

class KotlinInstance private constructor() {


    //首先将构造器private避免直接产生实例，然后使用伴生对象生成一个静态对象
    companion object {
        private const val TAG = "KotlinInstance"
        val kotlinInstance: KotlinInstance = KotlinInstance()
    }

    fun meth() {
        println(TAG + "这是 KotlinInstance里面方法")
    }

}

object KotlinInstance2 {

    val TAG: String = "KotlinInstance2"
    val kotlinInstance2: KotlinInstance2 = KotlinInstance2

    fun meth2() {
        println(TAG + "这是 KotlinInstance2里面方法")
    }

}


fun main(args: Array<String>) {
    //1，这样会报错，只能通过伴生对象生成
    // val kotlinInstance:KotlinInstance=KotlinInstance();
    val kotlinInstance: KotlinInstance = KotlinInstance.kotlinInstance
    kotlinInstance.meth()
    //2，使用object修饰类  直接让这个类变成单利
    val kotlinInstance2: KotlinInstance2 = KotlinInstance2.kotlinInstance2
    kotlinInstance2.meth2()


    //2,分别用 Array、IntArray、List 实现 「保存 1-100_000 的数字，并求出这些数字的平均值」，打印出这三种数据结构的执行时间。
    var start = 1
    val end = 100_000
    var total=0;

    val beginArrayTime:Long=System.currentTimeMillis()
    val array: Array<Int> = Array(end){ index -> index+1}
    for (index in array){
        total+=index
    }
    total /= end
   // val endArrayTime:Long=System.currentTimeMillis()
    println("array所用的时间为：${System.currentTimeMillis()-beginArrayTime}，平均数为：$total")

    total=0
    val beginintArrayTime:Long=System.currentTimeMillis()
    val intArray:IntArray=IntArray(end){ index -> index+1}
    for (index in intArray){
        total+=index
    }
    total /= end
    //val endintArrayTime:Int=System.currentTimeMillis().toInt()
    println("intarray所用的时间为：${System.currentTimeMillis()-beginintArrayTime}，平均数为：$total")


    total=0
    val beginListArrayTime:Long=System.currentTimeMillis()
    val list:List<Int> =List(end) { i -> i + 1 }
    for (index in list){
        total+=index
    }
    total /= end
    //val endListArrayTime:Int=System.currentTimeMillis().toInt()
    println("list所用的时间为：${System.currentTimeMillis()-beginListArrayTime}，平均数为：$total")

}