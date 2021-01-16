package ClassKotlin

import org.omg.CORBA.INTERNAL
import kotlin.math.sign

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


//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.associateWith { it.length })

//    val numbers = listOf("one", "two", "three", "four")
//    val numbersIterator = numbers.iterator()
//    while (numbersIterator.hasNext()) { println(numbersIterator.next()) }

//    val numbers = listOf("one", "two", "three", "four")
//    for (item in numbers) { println(item) }
//    numbers.forEach { println(it) }

//    val numbers = listOf("one", "two", "three", "four")
//    val listIterator = numbers.listIterator()
//    while (listIterator.hasNext())
//        listIterator.next()
//    println("Iterating backwards:")
//    while (listIterator.hasPrevious()) {
//        print("Index: ${listIterator.previousIndex()}")
//        println(", value: ${listIterator.previous()}") }

//    val numbers = mutableListOf("one", "two", "three", "four")
//    val mutableIterator = numbers.iterator()
//    mutableIterator.next()
//    mutableIterator.remove()
//    println("After removal: $numbers")


//    val numbers = mutableListOf("one", "four", "four")
//    val mutableListIterator = numbers.listIterator()
//    mutableListIterator.next()
//    mutableListIterator.add("two")
//    mutableListIterator.next()
//    mutableListIterator.set("three")
//    println(numbers)

//    val versionRange = NewVersion(1, 11)..NewVersion(1, 30)
//    println(NewVersion(0, 9) in versionRange)
//    println(NewVersion(1, 20) in versionRange)
//
//   val sss = IntProgression.fromClosedRange(1,9,2)

//    val oddNumbers = generateSequence(1) { it + 2 }
//    println(oddNumbers.take(5).toList())
//    println(oddNumbers.count()) // 错误：此序列是⽆限的。

//    val oddNumbersLessThan10 = generateSequence(1) { if (it + 2 < 10) it + 2 else null }
//    println(oddNumbersLessThan10.count())

//    val oddNumbers = sequence {
//        yield(1)
//        yieldAll(listOf(3, 5))
//        yieldAll(generateSequence(7) { it + 2 })
//    }
//    println(oddNumbers.take(10).toList())
//    println(oddNumbers.count())

//    val words = "The quick brown fox jumps over the lazy dog".split(" ")
//    val lengthsList = words.filter { println("filter: $it"); it.length > 3 } .map { println("length: ${it.length}"); it.length } .take(4)
//    println("Lengths of first 4 words longer than 3 chars:")
//    println(lengthsList)
//    println("----------------------------")
//
//    // 将列表转换为序列
//     val wordsSequence = words.asSequence()
//     val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 } .map { println("length: ${it.length}"); it.length } .take(4)
//     println("Lengths of first 4 words longer than 3 chars") // 末端操作：以列表形式获取结果。
//     println(lengthsSequence.toList())

//    val numbers = listOf("one", "two", "three", "four")
//    numbers.filter { it.length > 3 } // `numbers` 没有任何改变，结果丢失
//     println("numbers are still $numbers")
//     val longerThan3 = numbers.filter { it.length > 3 } // 结果存储在 `longerThan3` 中
//     println("numbers longer than 3 chars are $longerThan3")

    // val numbers = listOf("one", "two", "three", "four")
//    val filterResults = mutableListOf<String>() // ⽬标对象
//    numbers.filterTo(filterResults) { it.length > 3 }
//    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
//    println(filterResults) // 包含两个操作的结果

//    val result = numbers.mapTo(HashSet()) { it.length }
//    println("distinct item lengths are $result")

    //val numbers = mutableListOf("one", "two", "three", "four")
    // val sortedNumbers = numbers.sorted()
//    println(sortedNumbers)
//    println(numbers == sortedNumbers) // false
    //numbers.sort()
    // println(numbers)
//     println(numbers == sortedNumbers)

//    val numbers = setOf(1, 2, 3)
//    println(numbers.map { it * 3 })
//    println(numbers.mapIndexed { idx, value -> value * idx })

//    val numbers = setOf(1, 2, 3)
//    println(numbers.mapNotNull { if ( it == 2) null else it * 3 })
//    println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

//    val colors = listOf("red", "brown", "grey")
//    val animals = listOf("fox", "bear", "wolf")
//    println(colors zip animals)
//    val twoAnimals = listOf("fox", "bear")
//    println(colors.zip(twoAnimals))

//    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
//    println(numberPairs.unzip())

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.associateWith { it.length })

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.associateBy { it.first().toUpperCase() })
//    println(numbers.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))
//    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
//    println(numberSets.flatten())

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers)
//    println(numbers.joinToString())
//    val listString = StringBuffer("The list of numbers: ")
//    numbers.joinTo(listString)
//    println(listString)

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

//    val numbers = (1..100).toList()
//    println(numbers.joinToString(limit = 10, truncated = "<...>"))

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.joinToString { "Element: ${it.toUpperCase()}"})

//    val numbers = listOf("one", "two", "three", "four")
//    val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5) }
//    val filteredNot = numbers.filterNot { it.length <= 3 }
//    println(filteredIdx)
//    println(filteredNot)

//    val numbers = listOf("one", "two", "three", "four")
//    val (match, rest) = numbers.partition { it.length > 3 }
//    println(match)
//    println(rest)

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.any { it.endsWith("e") })
//    println(numbers.none { it.endsWith("a") })
//    println(numbers.all { it.endsWith("e") })
//    println(emptyList<Int>().all { it > 5 })

//    val numbers = listOf("one", "two", "three", "four")
//    val empty = emptyList<String>()
//    println(numbers.any())
//    println(empty.any())
//    println(numbers.none())
//    println(empty.none())

//    val numbers = listOf("one", "two", "three", "four")
//    val plusList = numbers + "five"
//    val minusList = numbers - listOf("three", "four")
//    println(plusList)
//    println(minusList)

//    val numbers = listOf("one", "two", "three", "four", "five")
//    println(numbers.groupBy { it.first().toUpperCase() })
//    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

//    val numbers = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers.groupingBy { it.first() }.eachCount())

//    val numbers = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers.slice(1..3))
//    println(numbers.slice(0..4 step 2))
//    println(numbers.slice(setOf(3, 5, 0)))

//    val numbers = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers.take(3))
//    println(numbers.takeLast(3))
//    println(numbers.drop(1))
//    println(numbers.dropLast(5))

//    val numbers = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers.takeWhile { !it.startsWith('f') })
//    println(numbers.takeLastWhile { it != "three" })
//    println(numbers.dropWhile { it.length == 3 })
//    println(numbers.dropLastWhile { it.contains('i') })

//    val numbers = (0..13).toList()
//    println(numbers.chunked(3))

//    val numbers = (0..13).toList()
//    println(numbers.chunked(3) { it.sum() }) // `it` 为原始集合的⼀个块

//    val numbers = listOf("one", "two", "three", "four", "five","six","seve")
//    println(numbers.windowed(3))

//    val numbers = (1..10).toList()
//    println(numbers.windowed(3, step = 2, partialWindows = true))
//    println(numbers.windowed(3) { it.sum() })

//    val numbers = listOf("one", "two", "three", "four", "five")
//    println(numbers.zipWithNext())
//    println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length})

//    val numbers = linkedSetOf("one", "two", "three", "four", "five")
//    println(numbers.elementAt(3))
//
//    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
//    println(numbersSortedSet.elementAt(0)) // 元素以升序存储

//    val numbers = listOf("one", "two", "three", "four", "five")
//    println(numbers.elementAtOrNull(5))
//    println(numbers.elementAtOrElse(5) { index -> "The value for index $index is undefined"})

//    class Version(val major: Int, val minor: Int) : Comparable<Version> {
//        override fun compareTo(other: Version): Int {
//            if (this.major != other.major) {
//                return this.major - other.major
//            } else if (
//                    this.minor != other.minor) {
//                return this.minor - other.minor
//            } else return 0
//        }
//    }
//
//        println(Version(1, 2) > Version(1, 3))
//        println(Version(2, 0) > Version(1, 5))

//    val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
//    println(listOf("aaa", "bb", "c","dddddd").sortedWith(lengthComparator))

//    println(listOf("aaa", "bb", "c").sortedWith(compareBy { it.length }))


//    val numbers = listOf("one", "two", "three", "four")
//    println("Sorted ascending: ${numbers.sorted()}")
//    println("Sorted descending: ${numbers.sortedDescending()}")

//    val numbers = listOf("one", "two", "three", "four")
    //   val sortedNumbers = numbers.sortedBy { it.length }
//    println("Sorted by length ascending: $sortedNumbers")
//    val sortedByLast = numbers.sortedByDescending { it.last() }
//    println("Sorted by the last letter descending: $sortedByLast")

//    val numbers = listOf("one", "two", "three", "four")
//    println("Sorted by length ascending: ${numbers.sortedWith(compareBy { it.length })}")

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.reversed())

//    val numbers = listOf("one", "two", "three", "four")
//    val reversedNumbers = numbers.asReversed()
//    println(reversedNumbers)

//    val numbers = mutableListOf("one", "two", "three", "four")
//    val reversedNumbers = numbers.asReversed()
//    println(reversedNumbers)
//    numbers.add("five")
//    println(reversedNumbers)

//    val numbers = listOf(5, 42, 10, 4)
//    val min3Remainder = numbers.minBy { it % 3 }
//    println(min3Remainder)

//    val strings = listOf("one", "two", "three", "four")
//    val longestString = strings.maxWith(compareBy { it.length })
//    println(longestString)

    //val numbers = listOf(5, 2)
//    val sum = numbers.reduce { sum, element -> sum + element }
//    println(sum)

//    val sumDoubled = numbers.fold(0) { sum, element -> sum + element * 2 }
//    println(sumDoubled)

//    val numbers = mutableListOf(1, 2, 5, 6)
//    numbers.addAll(arrayOf(7, 8))
//    println(numbers)
//    numbers.addAll(0, setOf(3, 4))
//    println(numbers)

//    val numbers = mutableListOf("one", "two", "three", "three", "four")
//   // numbers -= "three"
//    numbers -= listOf("three")
//    //numbers -= listOf("four") // 与上述相同 println(numbers)
//    println(numbers)

//    val numbers = listOf(1, 2, 3, 4)
//    println(numbers.get(0))
//    println(numbers[0])
//    //numbers.get(5) // exception!
//     println(numbers.getOrNull(5))
//    println(numbers.getOrElse(5, {it})) // 5

//    val numbers = listOf(1, 2, 3, 4, 2, 5)
//    println(numbers.indexOf(2))
//    println(numbers.lastIndexOf(2))

//    val numbers = mutableListOf("one", "two", "three", "four")
//    numbers.sort()
//    println(numbers)
//    println(numbers.binarySearch("two"))
//    println(numbers.binarySearch("z"))
//    println(numbers.binarySearch("two", 0, 3)) // -3

//    val colors = listOf("Blue", "green", "ORANGE", "Red", "yellow")
//    println(colors.binarySearch("green", String.CASE_INSENSITIVE_ORDER)) // 3

//    data class Product(val name: String, val price: Double)
//    fun priceComparison(product: Product, price: Double) = sign(product.price - price).toInt()
//    fun main1() {
//        val productList = listOf( Product("WebStorm", 49.0), Product("AppCode", 99.0), Product("DotTrace", 129.0), Product("ReSharper", 149.0))
//        println(productList.binarySearch { priceComparison(it, 99.0) }) }
//    main1()

//    val numbers = mutableListOf("one", "five", "six")
//    numbers.add(1, "two")
//    println(numbers)
//    numbers.addAll(2, listOf("three", "four"))
//    println(numbers)
//
//    val numbers = mutableListOf(1, 2, 3, 4)
//    numbers.fill(3)
//    println(numbers)

//    val numbers = mutableListOf("one", "two", "three", "four")
//    numbers . sort ()
//    println ("Sort into ascending: $numbers")
//    numbers . sortDescending ()
//    println ("Sort into descending: $numbers")
//    numbers . sortBy { it.length }
//    println ("Sort into ascending by length: $numbers")
//    numbers . sortByDescending { it.last() }
//    println ("Sort into descending by the last letter: $numbers")
//    numbers . sortWith (compareBy<String> { it.length }.thenBy { it })
//    println ("Sort by Comparator: $numbers")
//    numbers . shuffle ()
//    println ("Shuffle: $numbers")
//    numbers . reverse ()
//    println ("Reverse: $numbers")

//    val numbers = setOf("one", "two", "three")
//    println(numbers union setOf("four", "five"))
//    println(setOf("four", "five") union numbers)
//    println(numbers intersect setOf("two", "one"))
//    println(numbers subtract setOf("three", "four"))
//    println(numbers subtract setOf("four", "three")) // 相同的输出

//    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
//    println(numbersMap + Pair("four", 4))
//    println(numbersMap + Pair("one", 10))
//    println(numbersMap + mapOf("five" to 5, "one" to 11))

//    val numbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
//    numbersMap -= "one"
//    println(numbersMap)
//    numbersMap -= listOf("two", "four")
//            println(numbersMap)

    val numbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "threeAgain" to 3)
    numbersMap.keys.remove("one")
    println(numbersMap)
    numbersMap.values.remove(3)
    println(numbersMap)
}

class NewVersion(override var i: Int, override var i1: Int) : Version(i, i1) {
    override fun compareTo(other: Version): Int {
        if (this.i1 < other.i1) {
            return -1
        } else if (this.i1 == other.i1) {
            return 0
        } else {
            return 1
        }

    }
}

abstract class Version(open var i: Int, open var i1: Int) : Comparable<Version>

class Person(var name: String, var age: Int)
