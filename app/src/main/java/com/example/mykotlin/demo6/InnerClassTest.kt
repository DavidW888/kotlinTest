package com.example.mykotlin.demo6

class OutClass{
    val out:Int =10
    inner class InSideClass {
        val inside:Int =14
        fun insideTest(){
            println("insideTest获取外部属性out:$out")
        }
    }
    class InsideNormalClass(){
        val insideNormal:Int =55
        fun insideNormalTest(){
            //获取不到外部属性
            //println("insideTest获取外部属性out:$out")
            val insideTest = OutClass().InSideClass()
        }
    }
}

fun main(args: Array<String>) {
    //获取内部类,会默认获取外部的对象类
    val insideClass = OutClass().InSideClass()


    //获取嵌套类,默认为静态内部类
    val insideNormalClass = OutClass.InsideNormalClass()

}

