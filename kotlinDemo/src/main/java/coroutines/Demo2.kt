package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }
    coroutineScope {
        // 创建⼀个协程作⽤域
        launch {
            delay(500L)
            println("Task from nested launch")
        }
        delay(100L)
        println("Task from coroutine scope")
        //这⼀⾏会在内嵌 launch 之前输出 }
        println("Coroutine scope is over")
// 这⼀⾏在内嵌 launch 执⾏完毕后才输出
    }

}