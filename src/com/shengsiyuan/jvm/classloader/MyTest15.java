package com.shengsiyuan.jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];//（String表示是根类加载器，原生数据类型是没有类加载器的）
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("--------------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
