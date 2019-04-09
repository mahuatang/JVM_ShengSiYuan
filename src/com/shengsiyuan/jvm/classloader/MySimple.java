package com.shengsiyuan.jvm.classloader;

public class MySimple {
    public MySimple() {
        //会有加载MySimple这个类的类加载器来加载MyCat
        new MyCat();
    }
}
