package classkotlin

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator


open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4
}

fun main(args: Array<String>) {

    val subClass = Subclass("测试")
    subClass.demo(subClass)
}

class Subclass: Outer, Source<String> {
    var source: String? = null

    constructor(source: String) {
        this.source = source
    }

    override val b: Int
        get() = super.b

    private fun test() {
        val aaa: Int = 1
    }

    fun demo(strs: Source<String>) {
        val objects: Source<Any> = strs // 这个没问题，因为 T 是⼀个 out-参数 // ……

        print( objects.toString())
    }

    override fun nextT(): String? {
        if (source != null) {
            return source
        }
        return null
    }

}

interface Source<out T> {
    fun nextT(): T?
}

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator { PLUS {override fun apply(t: Int, u: Int): Int = t + u },TIMES { override fun apply(t: Int, u: Int): Int = t * u };override fun applyAsInt(t: Int, u: Int) = apply(t, u) }