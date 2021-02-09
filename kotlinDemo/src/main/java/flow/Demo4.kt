package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 使用flow和序列的运算符的区别在于，flow的中间运算符的代码可以是挂起函数
 */

private suspend fun flowSuspend(input: Int): String {
    delay(1000)
    return "print $input"
}

fun main() = runBlocking <Unit>{
    (1..10).asFlow().filter { it > 5 }.map { flowSuspend(it) }.collect { println(it) }

    println("----------------------")

    getTransform()

    println("----------------------")

    getLimitFlow().take(2).collect{ println(it)}

    println("----------------------")

    getReduce()
}


//transform加强版的map
private suspend fun getTransform() {
    (1..10).asFlow().transform {
        if (it % 2 == 0) {
            emit(it)
            emit(it)
        }
    }.collect { println(it) }
}

//限定flow的输出个数
//如果被取消将会抛出异常  kotlinx.coroutines.flow.internal.AbortFlowException: Flow was aborted, no more elements needed
private suspend fun getLimitFlow() = flow<Int> {
    try {
        emit(1)
        emit(2)
        println("hello kotlin")
        emit(3)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("finally")
    }
}

//flow的终止操作是挂起函数，终止操作后才会真正的开始执行流的收集
//reduce将flow中的元素全部使用对应的挂起函数收集起来
private suspend fun  getReduce(){
    val result=(1..4).asFlow().map {
        it .times(it)
    }.reduce{
        first ,end -> first+end
    }
    println(result)
}

