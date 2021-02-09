package coroutines

import kotlinx.coroutines.*

val threadLocal = ThreadLocal<String>()
fun main() = runBlocking {

// 在主协程中设置threadlocal的值
//    threadlocal.set("init")
//    println("当前线程的名字为：${Thread.currentThread().name},threadlocal init value : ${threadlocal.get()}")
//
//    val job = launch(Dispatchers.Default + threadLocal.asContextElement("YYYY")) {
//        // threadlocal.set("xxxxx")
//        val a = threadLocal.get()
//        println("yield before当前线程的名字为：${Thread.currentThread().name},threadlocal default change value : $a")
//        yield()
//        val b = threadLocal.get()
//        println("yield after当前线程的名字为：${Thread.currentThread().name},threadlocal default change value : $b}")
//
//    }
//
//    job.join()
//    println("当前线程的名字为：${Thread.currentThread().name},threadlocal init after value : ${threadlocal.get()}")

testAsContext()
}


fun testAsContext() = runBlocking {
    val tl = ThreadLocal.withInitial { "initial" }
    println(tl.get()+ "------${Thread.currentThread().name}") // Will print "initial"
    // Change context
    withContext(tl.asContextElement("modified")) {
        println(tl.get()+"*************${Thread.currentThread().name}") // Will print "modified"
    }
    // Context is changed again
    println(tl.get()) // <- WARN: can print either "modified" or "initial"
}


