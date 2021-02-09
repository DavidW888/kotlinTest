package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
使用flatMapConcat使得flow扁平化 Flow<Flow<Int>> -> Flow<Int>
 */

private suspend fun getFlatmapFlow(i: Int): Flow<String> = flow {
    emit("first emit $i")
    delay(500)
    emit("after emit $i")
}

fun main() = runBlocking{

    (1..4).asFlow().onEach { delay(500) }.flatMapConcat { getFlatmapFlow(it) }.collect{ println(it)}

    println("-----------------------------")
    getFlowData()
}

//flow捕获异常
private suspend fun  getFlowData(){
    try {
        (1..4).asFlow().collect{
            check(it <=2){
               "cause $it"
            }
            println(it)
        }
    } catch (e: Exception) {
        println(e)
    } finally {
        println("invoked")
    }

}

