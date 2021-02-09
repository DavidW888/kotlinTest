package coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    //withContext()是一个挂起函数，可以从withContext()中获取结果
    runBlocking {
        val result = withContext(Dispatchers.Unconfined) {
            delay(5000)
            "invoked"
        }

        println(result)

        //withTimeout()是一个挂起函数，会设定一个预期的时间，如果任务在这期间没有完成
        //将会抛出Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 2000 ms异常
        //要想不抛出异常需要使用函数withTimeoutOrNull()

//        withTimeout(2000) {
//            repeat(100) {
//                println("print i $it")
//                delay(300)
//            }
//
//        }

        normalFunction() //5003
        asyncFunction() //3009
    }


}

//使用普通的方式运行两个任务，计算其运行的时间
suspend fun normalFunction() {
    val elapseTime = measureTimeMillis {
        val num1 = addNum1()
        val num2 = addNum2();

        println("num1的值为$num1,num2的值为$num2 ,两数相加的值为${num1 + num2}")
    }
    println("normalFunction执行的时间为：$elapseTime")

}

//使用async /await函数并行执行,await函数会等待执行的结果
suspend fun asyncFunction() = runBlocking {
    val elapseTime = measureTimeMillis {

        val num1 = async { addNum1() }
        val num2 = async { addNum2() }

        println("num1的值为$num1,num2的值为$num2 ,两数相加的值为${num1.await() + num2.await()}")
    }
    println("asyncFunction执行的时间为：$elapseTime")


}

suspend fun addNum1(): Int {
    delay(2000)
    return 4

}

suspend fun addNum2(): Int {
    delay(3000)
    return 7

}