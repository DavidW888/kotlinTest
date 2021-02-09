package coroutines

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future


//ThreadLocal 可以在多线程中使用。每一个运行的线程会对应一个map，
// 将Threadlocal作为map的key,将所要存储的值作为value存储到对应的map中，起到了多线程读取各自的值
val threadlocal = ThreadLocal<String>()


fun main() {
    val treadPool = Executors.newFixedThreadPool(5)
    val furtureList = mutableListOf<Future<*>>()
    repeat(10) {
        val submit = treadPool.submit(Callable<String> {
            threadlocal.set("runnable $it")
            println("当前的线程名为：${Thread.currentThread().name},threadlocal中的值为${threadlocal.get()}")
            val retention =threadlocal.get()
            threadlocal.remove()
            retention
        })
        furtureList.add(submit)
    }

    for (index in furtureList){
        println("输出的结果为${index.get()}")
    }

    treadPool.shutdown()





}