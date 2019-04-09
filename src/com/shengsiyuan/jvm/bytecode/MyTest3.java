package com.shengsiyuan.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;


/**
 * 对于Java类中的每一个实例方法（非static方法），其在编译后所生成的字节码当中，方法参数的数量总是会比源代码中方法参数的数量多一个（this），它
 * 位于方法的第一个参数位置处；这样，我们就可以在Java的实例方法中使用this来去访问当前对象的属性以及其他方法。
 *
 * 这个操作是在编译期间完成的，即由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问，接下来在运行期间，由JVM在调用实例方法时，
 * 自动向实例方法传入该this参数。所以，在实例方法的局部变量表中，至少会有一个指向当前对象的局部变量。
 */

/**
 * public void test();
     descriptor: ()V
    flags: ACC_PUBLIC
    Code:
    stack（max_stack）=3（操作数栈的最大深度）, locals(max_locals)=4（最大局部变量的个数）, args_size=1（方法参数的个数）

    为何局部变量会有4个：

        this/is/serverSocket
        剩下一个是在try里面抛出的异常，异常对象只会赋值给三个异常对象中的一个。有可能三个都不进入，这里指的是最大数。
 */

/**
 * 部分助记符含义解析：
 * 以下5行（结合classlib分析）对应的实际上就是源代码：InputStream is = new FileInputStream("test.txt");
 * -new：创建对象
 * -dup：复制操作栈最顶层的值，实际就是压栈操作
 * -ldc：从运行期的常量池推一个item
 * -invokespecial：调用父类的相应构造方法
 * -astore_1:将引用存储到局部变量中
 *
 *
 * --sipush：将short值推送至栈顶（因为999归属于short）
 * --pop：将操作数栈最顶层的值pop出来，弹出
 * --astore_2:将引用赋给了局部变量
 *
 */

/**
 * Java字节码对于异常的处理方式：
 *
 * 1.统一采用异常表的方式来对异常进行处理。
 * 2.在jdk1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式。
 * 3.当异常处理存在finally语句块时，现代化的jvm采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面，
 * 换句话说，程序中存在多少个catch块，就会在每一个catch块后面重复多少个finally语句块的字节码。
 *
 *将异常主动抛出抛出时，和catch捕获异常时，在字节码中处的位置是不同的，抛出时所处的位置和code是同级的，在异常表中会看到，不管是运行时异常还是
 * 非运行时异常。
 *
 */
public class MyTest3 {
    public void test() throws IOException, FileNotFoundException, NullPointerException {
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }
}
