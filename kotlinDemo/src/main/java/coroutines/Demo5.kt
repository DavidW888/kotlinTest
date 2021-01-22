package coroutines

import com.sun.management.jmx.Trace.send
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
//    GlobalScope.launch {
//        val time = measureTimeMillis {
//            val one = doSomethingUsefulOne()
//            val two = doSomethingUsefulTwo()
//            println("The answer is ${one + two}")
//        }
//        println("Completed in $time ms")
//    }
//    runBlocking {
//        GlobalScope.launch(Dispatchers.Unconfined) {
//            val sum = (1..5).asFlow() .map { it * it }.reduce { a, b -> a + b } // 求和（末端操作符）
//            println(sum)
//        }
//    }

    //(1..3).asFlow().collect { value -> println(value) }

    fun produceNumbers() = produce<Long>() {
        var x = 1L
        while (true) send(x++) // infinite stream of integers starting from 1
    }

    fun square(numbers: ReceiveChannel<Long>) = produce<Long>() {
        for (x in numbers) send(x * x)
    }

    val numbers = produceNumbers() // produces integers from 1 and on
    val squares = square(numbers) // squares integers
    //for (i in 1..6) println(squares.receive())
    while (true) {
        println(squares.receive())
    }
    println("Done!")
    squares.cancel()
    numbers.cancel()
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}

