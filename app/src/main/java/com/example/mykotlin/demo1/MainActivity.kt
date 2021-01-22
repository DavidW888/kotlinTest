package com.example.mykotlin.demo1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlin.R

//3,添加一个新的属性（类型是非空的 View），在 onCreate 函数中初始化它。
private const val TAG = "WSSS"
class MainActivity : AppCompatActivity() {
    lateinit var textView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textview)

        //4,声明一个参数为 View? 类型的方法，传入刚才的 View 类型属性，并在该方法中打印出该 View? 的 id。
        printViewId(textView)
        if (textView is TextView){
            (textView as TextView).text="xxxx"
        }

        val sunClass:FatherClass =SunClass()
        Log.i(TAG, "${sunClass is SunClass} ")
        Log.i(TAG, "${sunClass is FatherClass} ")

        if(sunClass is SunClass){
            sunClass.getText()

        }


    }

    fun printViewId(view: View?) {
        println("view的ID:" + view?.id)
    }




}




//1,子类重写父类的 override 函数，能否修改它的可见性？
open class FatherClass {
    //父类方法默认是public
    protected open fun call() {

    }


}

open class SunClass : FatherClass() {
    public final override fun call() {
        super.call()
    }

    fun getText(){
        println("这是SunClass的方法")
    }
}



//子类能改变父类ovrride方法的可见性


//2,比较区别
/*
//fatherClass as? SunClass
//fatherClass as SunClass?
//fatherClass as? SunClass?
*/

fun main(args: Array<String>) {
    var fatherClass:FatherClass? =SunClass()
    fatherClass= null
    //如果能正常转化就是SunClass，不能就是null
    println(fatherClass as? SunClass)
    //如果类型不匹配会抛出异常：exception in thread "main" java.lang.ClassCastException: com.example.mykotlin.demo1.FatherClass cannot be cast to com.example.mykotlin.demo1.SunClass
    println(fatherClass as SunClass?)
    //如果能正常转化就是SunClass，不能就是null
    println(fatherClass as? SunClass?)
}



