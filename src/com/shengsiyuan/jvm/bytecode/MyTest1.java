package com.shengsiyuan.jvm.bytecode;

/**
 * 虚拟机栈：Stack Frame 栈帧
 * 程序计数器（Program Counter）：
 * 本地方法（native method）栈：主要用于处理本地方法
 * 堆（Heap）：JVM管理的最大一块内存空间
 * 方法区（Method Area）：存储元信息。永久代（Permanent Generation），从JDK1.8开始，已经彻底废弃了永久代，
 * 使用元空间（meta space）
 *
 * 运行时常量池：方法区的一部分内容。
 * 直接内存：Direct memory
 *
 *
 */

public class MyTest1 {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
