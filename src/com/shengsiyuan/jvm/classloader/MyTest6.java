package com.shengsiyuan.jvm.classloader;

public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1: " + Singleton.count1);
        System.out.println("counter2: " + Singleton.count2);
    }
}

class Singleton {
    public static int count1;

    public static int count2 = 0;



    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
    private static  Singleton singleton = new Singleton();
}
