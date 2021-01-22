package channel

import javafx.application.Application.launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.IOException
import kotlin.coroutines.CoroutineContext

fun main(args: Array<String>) = runBlocking{
//    val channel = Channel<Int>()
//    launch { for (x in 1..5)
//        channel.send(x * x)
//        //channel.close()
//        }
//        // 我们结束发送 }// 这⾥我们使⽤ `for` 循环来打印所有被接收到的元素（直到通道被关闭）
//    println(channel.receive())
//    println(channel.receive())
//    println(channel.receive())
//    println(channel.receive())
//    println(channel.receive())
//    //repeat(5) { println(channel.receive()) }
//    println("Done!")

//    val channel = Channel<Int>()
//    launch { for (x in 1..5) channel.send(x * x)
//        channel.close() // 我们结束发送
//         }// 这⾥我们使⽤ `for` 循环来打印所有被接收到的元素（直到通道被关闭）
//    for (y in channel) println(y)
//    println("Done!")

    fun sum(x: Int, y: Int, z: Int): Int {
        val delta = 0;
        fun add(a: Int, b: Int): Int {
            return a + b + delta
        }
        return add(x , add(y, z))
    }

    println("sum(1,2,3) = ${sum(1, 2, 3)}")



}

fun File.copyRecursively(
        target: File,
        overwrite: Boolean = false, // 是否覆盖。true：覆盖之前先删除原来的文件
        onError: (File, IOException) -> OnErrorAction={ file: File, ioException: IOException -> throw ioException }
): Boolean {
   return true
}






