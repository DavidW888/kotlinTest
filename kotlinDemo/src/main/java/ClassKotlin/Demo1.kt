package ClassKotlin


fun main(args: Array<String>) {

    val initOrderDemo = InitOrderDemo("测试类构造器")
    // Constructors(1);
    //Derived("jJJ","333")


}

interface MyInterface {
    fun bar()
    fun foo()
}


class InitOrderDemo(name: String) {
    lateinit var setterVisibility: String
    fun add(s: String) {
        println(s)
    }

    val firstProperty = "First property: $name".also(this::add)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

open class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

class NewConstructors(i: Int) : Constructors(i) {

}

open class Base(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also { println("Initializing size in Base: $it") }
}

class Derived(name: String, val lastName: String) : Base(name.capitalize().also { println("Argument for Base: $it") }) {
    init {
        println("Initializing Derived")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}