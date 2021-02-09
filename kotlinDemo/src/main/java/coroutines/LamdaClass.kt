package coroutines
/*
lamda表达式
 */

fun main() {
    val lamdaClass = LamdaClass();
    val test1 = lamdaClass::test1
    lamdaClass.test3(11, test1)
    lamdaClass.test3(13, ::test11)

    lamdaClass.test3(11) {

        println(it + 1)
    }

    lamdaClass.test4(11) { a: Int, b: String ->
        println("a=$a ,b=$b")
        b

    }
}

fun test11(a: Int) {
    println("test11 ，a=$a")
}

class LamdaClass {
    fun test1(a: Int) {
        println("test1 ，a=$a")
    }

    fun test2(a: Int, b: Int) {

    }

    fun test3(a: Int, function: (Int) -> Unit) {
        function(a)
    }

    fun test4(a: Int, function: (Int, String) -> String) {
        function(a, a.toString() + "qqqqq")
    }
}

