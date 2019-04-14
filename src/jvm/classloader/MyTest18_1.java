package jvm.classloader;

public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        //可以将class文件放在启动类加载器的路径，也可以由启动类加载器加载
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/zhanglong/Desktop/");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.re.MyTest1");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());


    }
}
