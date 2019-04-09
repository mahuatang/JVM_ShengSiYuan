package com.shengsiyuan.jvm.classloader;

public class MyTest25 implements Runnable {

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class : " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }

    /**
     * 原因：
     *
     * public class Launcher {
     private static URLStreamHandlerFactory factory = new Launcher.Factory();
     private static Launcher launcher = new Launcher();
     private static String bootClassPath = System.getProperty("sun.boot.class.path");
     private ClassLoader loader;
     private static URLStreamHandler fileHandler;

     public static Launcher getLauncher() {
     return launcher;
     }

     public Launcher() {
     Launcher.ExtClassLoader var1;
     try {
     var1 = Launcher.ExtClassLoader.getExtClassLoader();
     } catch (IOException var10) {
     throw new InternalError("Could not create extension class loader", var10);
     }

     try {
     this.loader = Launcher.AppClassLoader.getAppClassLoader(var1);
     } catch (IOException var9) {
     throw new InternalError("Could not create application class loader", var9);
     }
/////////////////////////////////////////////////////////////////
     Thread.currentThread().setContextClassLoader(this.loader);
    ///////////////////////////////////////////////////////////////
     */
}
