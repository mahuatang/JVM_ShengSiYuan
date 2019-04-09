package com.shengsiyuan.jvm.classloader;

/**
 * 扩展类加载器比较特殊，它不会直接加载路径下的.class文件，需要把这个class文件打成jar包才可以加载。
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
