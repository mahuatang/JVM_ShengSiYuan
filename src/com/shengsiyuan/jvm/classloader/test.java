package com.shengsiyuan.jvm.classloader;

public class test {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a == b);

        System.out.println(a == 100);
    }
}
