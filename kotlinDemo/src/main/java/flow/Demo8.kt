package flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
    onCompletion使用声明式表达完成
 */

private fun getFlow(): Flow<Int> = flow<Int> {
    for (index in 1..4) {
        emit(index)
    }
}

fun main() = runBlocking {
    getFlow().onCompletion { println("invoked") }.collect { println(it) }

    println("------------------")
    getFlowException()

    println("------------------")
    getFlowExceptionbeforCompletion()

}

private fun getFlowException() = runBlocking {
    flow<Int> {
        emit(1)
        throw  RuntimeException("异常啦")
    }.onCompletion { cause -> if (cause != null) println("onCompletion from $cause") }
            .catch { println("cause by $it") }.collect { println(it) }
}


private fun getFlowExceptionbeforCompletion() = runBlocking {
    flow<Int> {
        emit(1)
        emit(3)
    }.onCompletion { cause ->
        println("onCompletion from $cause")
    }.collect {
        check(it < 3) {
            "异常啦"
        }
        println(it)
    }
}