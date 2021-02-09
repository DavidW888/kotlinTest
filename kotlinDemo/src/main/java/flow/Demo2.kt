package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


private fun getFlowMeth() = flow<Int> {
    for (i in 1..4) {
        delay(500)
        emit(i)
    }

}


fun main() = runBlocking {
    launch {
        for (i in 1..4) {
            println("hello $i")
            delay(500)
        }

    }

    //getFlowMeth()不是挂起函数，当launch新开了一个协程不会阻塞线程，getFlowMeth()会运行
    //flow中的代码是可以挂起的，使用emit()发送数据，使用collect()来接收数据
    //flow只有调用终止操作后才会真正执行
    getFlowMeth().collect() { println(it) }
}

