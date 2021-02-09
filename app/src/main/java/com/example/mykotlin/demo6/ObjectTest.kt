package com.example.mykotlin.demo6

object  ObjectTest{
    val a:Int =0;
    fun test(){
    }
}

class ObjectTest2{
    //在普通类中使用无效
    @JvmField val b:Int =3
    //报错，只能在伴生对象或者object中使用
//    @JvmStatic fun test1{}


}

object  ObjectTest3{
    @JvmField val c:Int =0;
    @JvmStatic fun test3(){
    }
}

//使用伴生对象

class ObjectTest4{
    val d:Int =0

    companion object {
        val c:Int =4
        fun test4(){}

    }

}

class ObjectTest5{

    companion object {
        @JvmField val d:Int =5
        @JvmStatic fun test5(){}

    }

}




fun main(args: Array<String>) {
    val a = ObjectTest.a
    ObjectTest.test()

    val b:Int = ObjectTest2().b

    val objectTest3 = ObjectTest3
    objectTest3.c
    objectTest3.test3()

   //伴生对象可以取消类名,取消类名之后是以Companion为名
    val objectTest4 = ObjectTest4()
    objectTest4.d
    val c = ObjectTest4.c
    ObjectTest4.test4()

    val objectTest5 = ObjectTest5()
    ObjectTest5.d
    ObjectTest5.test5()

}