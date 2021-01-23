package com.example.mykotlin.demo3





/**
 * 请按照以下要求实现一个 Student 类：

写出三个构造器，其中一个必须是主构造器
主构造器中的参数作为属性
写一个普通函数 show，要求通过字符串模板输出类中的属性
 */
class Student(name: String) {
    var grade: String = ""
    var age: Int = 0
    var name: String = ""

    init {
        this.name = name
        println("执行了init函数")
    }

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    constructor(name: String, age: Int, grade: String) : this(name, age) {
        this.age = age
        this.grade = grade
    }

    fun show() {
        println("学生的名字是：$name,年龄是：$age,年级是：$grade")
    }
}


fun main(args: Array<String>) {
    //val student1=Student("小王")
    // student1.show()
    val student2 = Student("小张", 11)
    student2.show()
//    val student3=Student("小赵",14,"一年级")
//    student3.show()

//找出集合 {21, 40, 11, 33, 78} 中能够被 3 整除的所有元素，并输出。

    val list= listOf<Int>(21, 40, 11, 33, 78)
    list.filter { it -> it % 3 == 0 }.forEach{println(it)}
}