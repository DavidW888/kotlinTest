package flow

/*
*
* 使用序列中的数据并不会像集合那样一次性就返回给调用端，而是计算完一个数据之后就返回一个数据
* 数列中的计算过程会使用主线程来进行，因此它会阻塞主线程的执行
*
* */

private fun getMeth1() = sequence<Int> {
    for (index in 1 ..5){
        Thread.sleep(1000)
        yield(index)
    }
}

fun main() {
    for (item in getMeth1()) {
        println(item)
    }
}