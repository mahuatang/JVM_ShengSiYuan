package jvm.bytecode;

import java.util.Date;

/**
 * 针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table，vtable），
 *  针对于invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构（interface method table， itable）。
 *
    子类如果没有重写父类的方法，那么对子类的方法引用会指向父类的方法地址；重写完了就指向子类。
    子类重写的父类方法的索引号和父类是一样的,这样方便查找。

 */

public class MyTest7 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }

}

class Animal {
    public void test(String str) {
        System.out.println("animal str");
    }

    public void test(Date date) {
        System.out.println("animal date");
    }

}

class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("dog date");
    }
}
