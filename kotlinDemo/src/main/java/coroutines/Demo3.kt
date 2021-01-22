package coroutines

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
//    launch { doWorld() }
//    println("Hello,")
    // 这是你的第⼀个挂起函数

//    GlobalScope.launch { repeat(1000) { i -> println("I'm sleeping $i ...")
//        delay(500L) } }
//    delay(1300L) // 在

//    val job = launch {
//        repeat(1000) { i ->
//            println("job: I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//    delay(1300L) // 延迟⼀段时间
//    println("main: I'm tired of waiting!")
//    job.cancel()
//    job.join()
//    println("main: Now I can quit.")

    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(
                NonCancellable
            ) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
           }
        }
    }
    delay(1300L)
    // 延迟⼀段时间
     println("main: I'm tired of waiting!")
     job.cancelAndJoin()
    // 取消该作业并等待它结束
    println("main: Now I can quit.")

}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}


