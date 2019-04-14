package jvm.classloader;

public class MyTest7 {
    public static void main(String[] args) throws  Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.shengsiyuan.jvm.re.cc");
        System.out.println(clazz2.getClassLoader());
    }
}

class cc {

}
