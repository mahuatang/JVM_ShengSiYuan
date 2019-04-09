package com.shengsiyuan.jvm.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}
//调用Classloader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
public class MyTest12 {
    public static void main(String[] args) throws Exception{
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("-----------");

        clazz= Class.forName("com.shengsiyuan.jvm.classloader.CL");

        System.out.println(clazz);
    }
}
