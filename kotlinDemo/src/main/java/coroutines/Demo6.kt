package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //GlobalScopes是CoroutineScope的子类，是协程作用的范围，launch函数会在后台启动一个协程
    GlobalScope.launch {
        //delay是一个挂起函数，不会阻塞线程，会让当前协程延迟一段时间后运行
        delay(1000)
        println("hello coroutines ,currentTheadname:${Thread.currentThread().name}")
    }
    println("hello main")
    Thread.sleep(2000)
    println("world main ,currentTheadname:${Thread.currentThread().name}")

    //runBlocking会重新创建一个新的协程，并且会阻塞当前线程
    runBlocking {
        Thread.sleep(2000)
        println("over")
    }

}