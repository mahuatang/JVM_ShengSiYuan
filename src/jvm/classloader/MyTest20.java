package jvm.classloader;

import java.lang.reflect.Method;

public class MyTest20 {
    public static void main(String[] args) throws Exception{
        /**
         * 此时load1的父类加载器和loader2的父类加载器是同一个加载器（系统类加载器）
         * 它们在同一个命名空间中
         */
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");

        System.out.println("****************");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
