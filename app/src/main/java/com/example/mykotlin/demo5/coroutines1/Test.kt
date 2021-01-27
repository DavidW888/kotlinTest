package com.example.mykotlin.demo5.coroutines1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//1,开启一个协程，并在协程中打印出当前线程名。

fun main(args: Array<String>) {

    GlobalScope.launch {
        println("1,当前线程名" + Thread.currentThread().name)
    }
    GlobalScope.launch(Dispatchers.Unconfined) {
        println("2,当前线程名" + Thread.currentThread().name)
    }

    GlobalScope.launch(Dispatchers.Default) {
        println("3,当前线程名" + Thread.currentThread().name)
    }

    GlobalScope.launch(Dispatchers.IO) {
        println("4,当前线程名" + Thread.currentThread().name)
    }


}