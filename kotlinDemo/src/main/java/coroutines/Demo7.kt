package coroutines

import kotlinx.coroutines.*

fun main() {

    runBlocking {
        //launch函数无法得到，协程运行的结果，但是可以返回一个Job实例，得到协程运行的状态
        val job =GlobalScope.launch {
            delay(1000)
            println("world")
        }

        println("hello")
        //join方法是个挂起函数会等待job对应的协程运行完毕
        job.join()
        println("over")

        println("---------------------------------")
        val job2= test1()
        job2.join()
    }

}


//每个协程构建器都会向代码作用域中添加一个CoroutineScope实例，我们可以在该作用域中启动协程而无需显示的添加join
//外部协程会等待作用域中所有的协程全部执行完之后才结束
suspend fun test1()= GlobalScope.launch{
        launch {
            delay(1000)
            println("world--test1")
        }

        println("hello--test1")
    }
