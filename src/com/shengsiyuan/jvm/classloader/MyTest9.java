package com.shengsiyuan.jvm.classloader;

public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }
    public static void main(String[] args) {
        System.out.println(Child.a);
    }

}


class parent {
    static int a = 3;

    static {
        System.out.println("Patent static block");
    }
}

class Child extends parent {
    static final int b = 4;
    static {
        System.out.println("Child static block");
    }

}


