package com.example.mykotlin.demo6;

class JavaObjectTest {
    public static void main(String[] args) {
        //在Java中直接使用object对象
        ObjectTest objectTest = ObjectTest.INSTANCE;
        objectTest.getA();  //访问属性
        objectTest.test();  //访问方法


        //在Java中使用带@JvmField注解的属性
        ObjectTest2 objectTest2  = new ObjectTest2() ;
        int a = objectTest2.b;

        //在Java中使用带@JvmField注解的属性，以及带@JvmStatic的方法
        ObjectTest3 objectTest3 = ObjectTest3.INSTANCE;
        ObjectTest3.test3();
        int c= ObjectTest3.c;


        //在Java中使用带伴生对象的对象
        ObjectTest4 objectTest4 = new ObjectTest4() ;
        objectTest4.getD();
        ObjectTest4.Companion.getC();
        ObjectTest4.Companion.test4();

        //在Java中使用带伴生对象的对象并使用平台注解
        ObjectTest5  objectTest5  = new ObjectTest5() ;
        ObjectTest5.test5();
        int d =ObjectTest5.d;



    }
}
