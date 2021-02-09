package coroutines

import kotlinx.coroutines.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/**
 * async 默认是CoroutineStart.DEFAULT 直接运行协程代码
 * 可以自己定义CoroutineStart.LAZY来实现延迟执行
 */
fun main() = runBlocking {
    val elpTime = measureTimeMillis {
        //async 执行返回Deferred，是Job的子类，可以调用await()方法获取结果，也可以使用start()方法开启携程
        val addDemo9Num1 = async(start = CoroutineStart.LAZY) { addDemo9Num1() }
        val addDemo9Num2 = async(start = CoroutineStart.LAZY) { addDemo9Num2() }

        println("hello world")
        Thread.sleep(5000)

        //首先要start()开启协程运行
        addDemo9Num1.start()
        addDemo9Num2.start()

        //首先要await()等待协程运行结果
        val result1 = addDemo9Num1.await()
        val result2 = addDemo9Num2.await()

        println("result1：$result1,result2：$result2,两值相加的结果：${result1+result2}")


    }
    //先调用start()再调用await()方法，会并行执行  8017
    //不调用start()直接调用await()方法，会串行执行 10023
     println("LAZY函数执行的结果为：$elpTime")



}

suspend fun addDemo9Num1(): Int {
    delay(2000)
    return 4

}

suspend fun addDemo9Num2(): Int {
    delay(3000)
    return 7

}