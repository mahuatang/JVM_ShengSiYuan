package re;

class CL {
    static {
        System.out.println("static CL");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.re.CL");
        System.out.println(clazz);

        System.out.println("----------");

        clazz = Class.forName("com.shengsiyuan.jvm.re.CL");
        System.out.println(clazz);
    }
}
