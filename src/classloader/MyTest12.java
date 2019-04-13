package classloader;

class CL {
    static {
        System.out.println("static CL");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("----------");

        clazz = Class.forName("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);
    }
}
