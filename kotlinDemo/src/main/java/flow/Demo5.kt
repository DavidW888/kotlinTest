package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/*
使用flowOn可以让 FlOW的发射元素时所处的上下文和收集时所处的上下文是不同的
flowOn运算符改变了flow本身的顺序性
 */
private fun getMeth(): Flow<Int> = flow {
    for (i in 1..4) {
        Thread.sleep(1000)
        println("emit $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    getMeth().collect{ println(it)}

}