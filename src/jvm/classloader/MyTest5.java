package jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
       // System.out.println(MyChild5.a);
        new c();
        new c();
    }
}

interface MyParent5 {
    public static final int a = new Random().nextInt(3);
    public static final Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

interface MyChild5 extends MyParent5 {
    public static final int b = 5;
}

class c {
    {
        System.out.println("Hello");//每个C的实例被创建时，这个块都会被执行一次
    }

    public c() {
        System.out.println("C");
    }
}
