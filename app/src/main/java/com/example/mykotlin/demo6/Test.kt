package com.example.mykotlin.demo6

import kotlinx.coroutines.*


fun test1() = runBlocking {
    val myThreadLocal = ThreadLocal<String?>()

    println(myThreadLocal.get()) // Prints "null"
    launch(Dispatchers.Default + myThreadLocal.asContextElement(value = "foo")) {
        println(myThreadLocal.get()) // Prints "foo"
        withContext(Dispatchers.Main) {
            println(myThreadLocal.get()) // Prints "foo", but it's on UI thread
        }
    }
    println(myThreadLocal.get()) // Prints "null"
}