package com.shengsiyuan.jvm.bytecode;

/**
 * new操作总共做了三件事（乱写的）：
 * 1。在堆上开辟一块内存空间，生成对象
 * 2。调用类的构造方法
 * 3。将对象的引用传递给目标
 *
 *
 * 对应助记符：
 * new   创建对象
 * dup     压入栈顶
 * invokespecial 调用构造方法
 * astore_1 将引用存储到局部变量中
 *
 *
 * astore_n:中的n是将返回来的引用存储到第n个局部变量中。
 * aload_n:从局部变量中加载索引为n的引用
 *
 * 方法的动态分派
 *
 * 方法的动态分派涉及到一个重要概念：方法接受者。
 *
 * invokevirtual字节码指令的多态查找流程
 *
 * 1。找到操作数栈顶的第一个元素，它所指向的对象的实际类型。
 * 2。如果在这个实际的类型当中，寻找到特定方法（与常量池中方法名、描述符等等相同）。
 * 如果找到了，就直接调用特定的方法；如果找不到，从子类到父类逐个查找，直到找到为止。
 * 如果一直找不到，抛异常。
 *
 * 比较方法重载（overload）与方法重写，我们可以得到这样的结论：
 *
 * 方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}
