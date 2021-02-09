package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    flow使用命令式表达完成
 */

private fun getFlow(): Flow<Int> = flow<Int> {
    for (index in 1.. 4){
        emit(index)
    }
}

fun main()  = runBlocking{
    try {
        getFlow().collect { println(it) }
    } finally {
        println("invoked")
    }

}