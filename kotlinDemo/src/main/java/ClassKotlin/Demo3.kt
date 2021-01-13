package ClassKotlin

import com.sun.corba.se.impl.orbutil.graph.Graph
import sun.security.provider.certpath.Vertex
import kotlin.properties.Delegates
import kotlin.properties.Delegates.vetoable
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty


fun main(args: Array<String>) {
//    val b = BaseImpl(10)
//    val derived = Derived1(b)
//    derived.print()
//    println(derived.message)

//    val user = User()
//    user.name = "first"
//    user.name = "second"

    val items = listOf(1, 2, 3, 4, 5)
    // Lambdas 表达式是花括号括起来的代码块。
//    items.fold(0,{
//        // 如果⼀个 lambda 表达式有参数，前⾯是参数，后跟“->”
//        acc: Int, i: Int ->
//        print("acc = $acc, i = $i, ")
//        val result = acc + i
//        println("result = $result")
//        // lambda 表达式中的最后⼀个表达式是返回值：
//        result
//    })

//    val joinedToString = items.fold("Elements:", { acc:String, i:Int -> acc + " " + i })
//    print(joinedToString)

//    val product = items.fold(1, Int::times)

    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun
    fun runTransformation(f: (String, Int) -> String): String {
        return f("h", 3)
    }

    val result = runTransformation(repeatFun) // OK

    // print(result)

    val strings = mapOf("111" to 1, "fsdfs" to "dcsds")

    //print(strings.filter { it.length == 5 }.sortedBy { it }.map { it.toUpperCase() })

    strings.forEach { key, value -> println("$key  $value!") }

    val numbers = mutableListOf("one", "two", "three", "four")
}

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0)
            return true
    }
    return false
}


fun <T, R> Collection<T>.fold(initial: R, combine: (acc: R, nextElement: T) -> R): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}


class User {
    var name: String by vetoable("初始化") { kProperty: KProperty<*>, s: String, s1: String -> true }
}

interface Base1 {
    val message: String
    fun print()
}

class BaseImpl(val x: Int) : Base1 {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }
}

class Derived1(b: Base1) : Base1 by b {
    override val message = "Message of Derived"
}