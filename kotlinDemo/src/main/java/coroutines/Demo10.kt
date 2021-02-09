package coroutines

import kotlinx.coroutines.*

//模拟安卓的activity调用，在activity结束的时候，需要取消activity中的所有协程防止内存泄漏
class Activity :CoroutineScope  by CoroutineScope(Dispatchers.Default){
    fun destroy(){
        cancel()
    }

    fun doSometing(){
        repeat(8){
            launch {
                delay((it +1)*500L)
                println("启动的协程为coroutine: $it")
            }
        }
    }
}


fun main() = runBlocking{
    val activity = Activity()
    println("activity开始运行")
    //模拟activity启动若干个任务
    activity.doSometing()
    //避免协程全部运行
    delay(2000)
    //取消没有完成的协程
    activity.destroy()
    println("activity运行完毕")

    delay(9000)

}

