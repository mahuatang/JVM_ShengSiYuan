package com.shengsiyuan.jvm.bytecode;

public class MyTest2 {
    String str = "welcome";
    private int x = 5;
    public static Integer in = 10;

   // private Object object = new Object();

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str) {
        synchronized (str) {//对传进来的参数上锁,其实起不到什么上锁的作用，因为传进来的对象不同，互不影响。
            System.out.println("hello world");
        }
    }

    private synchronized static void test2() {

    }
}
