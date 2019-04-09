package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader{
    private String classLoaderName;

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();//将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    /**
     * Constructor<?> ctor = Class.forName(cls, true, parent)
     .getDeclaredConstructor(new Class<?>[] { ClassLoader.class });
     * @param parent
     */
    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    /**
     * 要遵循双亲委托模型（估对）
     * 在检查完父加载器之后会被loadclass调用
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + name);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        System.out.println(name);

        name = name.replace(".", "/");

        System.out.println(name);
        System.out.println(this.path + name + this.fileExtension);

        try {
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch;

            while(-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yurui/Desktop/项目代码/java8/JVMLecture/out/production/JVMLecture/com/shengsiyuan/jvm/classloader");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();

        //如下代码是在模拟类的卸载
        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        Thread.sleep(20000);

        /**
         * load1和load2在classpath不存在对应class的情况下，都会各自去加载，虽然类只会被加载一次，但他们属于不同的命名空间
         */

        /*loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yurui/Desktop/项目代码/java8/JVMLecture/out/production/JVMLecture/com/shengsiyuan/jvm/classloader");

        clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

        System.out.println();*/

       /* MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("/Users/yurui/Desktop/项目代码/java8/JVMLecture/out/production/JVMLecture/com/shengsiyuan/jvm/classloader");

        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

        System.out.println();*/


    }
}
