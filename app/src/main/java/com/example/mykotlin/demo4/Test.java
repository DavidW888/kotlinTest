package com.example.mykotlin.demo4;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class Test {

    //java中的数组支持协变
    Integer[] integers =new Integer[] {1,2 ,3};
    Number[] numbers=integers;


    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();

        //arrayList.add(100); 在编译阶段，编译器就会报错

        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();
        System.out.println(classStringArrayList);
        //泛型在编译时，会导致类型擦除
        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试 类型相同");
        }


//        try {
//            Object obj = genericMethod(Class.forName("com.test.test"));
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }



        //数组协变
        Integer[] integers=new Integer[10] ;
        integers[0]=1;
        Number[] numbers = integers;
        System.out.println(numbers[0].getClass().getCanonicalName());
    }


    public static <T> T genericMethod(Class<T> tClass)throws InstantiationException , IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
}
