package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        /**
         * java.lang.reflect.Proxy.ProxyClassFactory
         *    byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
         proxyName, interfaces, accessFlags);

         代理类本身也是一个字节数组

         -----------------------------------------------------------------------

         sun.misc.ProxyGenerator

         private static final boolean saveGeneratedFiles =
         ((Boolean)AccessController.doPrivileged(new GetBooleanAction("sun.misc.ProxyGenerator.saveGeneratedFiles"))).booleanValue();

         -----------------------------------------------------------------------
         *
         * 除了request会被代理，默认还有Object的三个方法会被自动代理，他们分别是hashCode、toString、equals
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");//设置为true将会把代理类写到磁盘上（估对）
        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);//生成的这个类是代理类的子类

        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());


    }
}
