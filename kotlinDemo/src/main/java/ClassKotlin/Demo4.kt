package ClassKotlin

fun main(args: Array<String>) {
//    fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
//        this.filterTo(shortWords) { it.length <= maxLength }
//        val articles = setOf("a", "A", "an", "An", "the", "The")
//        shortWords -= articles
//    }
//
//    val words = "A long time ago in a galaxy far far away".split(" ")
//    val shortWords = mutableListOf<String>()
//    words.getShortWordsTo(shortWords, 3)
//    println(shortWords)

//    val bob = Person("Bob", 31)
//    val people = listOf(bob, 2, 3,4)
//    val people2 = listOf(1, 2, 3,4)
//    println(people == people2)
//    bob.age = 32
//    println(people == people2)

//    val numbers = mutableListOf(1, 2, 3, 4)
//    numbers.add(5)
//    numbers.removeAt(1)
//    numbers[0] = 0
//    numbers.shuffle()
//    println(numbers)

//

//    val numbersMap = mutableMapOf("one" to 1, "two" to 2)
//    numbersMap.put("three", 3)
//    numbersMap["one"] = 11
//    println(numbersMap)

//    val doubled = List(3, { it * 2 }) // 如果你想操作这个集合，应使⽤ MutableList
//     println(doubled)

//    val sourceList = mutableListOf(1, 2, 3)
//    val copyList = sourceList.toMutableList()
//    val readOnlyCopyList = sourceList.toList()
//    sourceList.add(4)
//    println("Copy size: ${copyList.size}")
//    //readOnlyCopyList.add(4) // 编译异常
//    println("Read-only copy size: ${readOnlyCopyList.size}")

//    val sourceList = mutableListOf(1, 2, 3)
//    val copySet = sourceList.toMutableSet()
//    copySet.add(3)
//    copySet.add(4)
//    println(copySet)

//    val sourceList = mutableListOf(1, 2, 3)
//    val referenceList = sourceList
//    referenceList.add(4)
//    println("Source size: ${sourceList.size}")


//    val sourceList = mutableListOf(1, 2, 3)
//    val referenceList: List<Int> = sourceList
    // referenceList.add(4) // 编译错误
//     sourceList.add(4)
//     println(referenceList) // 显⽰ sourceList 当前状态


//    val numbers = setOf(1, 2, 3)
//    println(numbers.map { it * 3 })
//    println(numbers.mapIndexed { idx, value -> value * idx })


    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
}

class Person(var name: String, var age: Int)
