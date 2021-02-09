package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.flow.collect

//flow的收集操作是可以被终止的，只能在挂起函数中被取消

private fun getFlowMeth() = flow<Int> {
    for (index in 1..4) {
        delay(500)
        emit(index)
    }
}


fun main() = runBlocking {
    withTimeoutOrNull(1500) {
        getFlowMeth().collect { println(it) }
    }
    println("invoke finish")
}

