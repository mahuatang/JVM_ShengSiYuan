package re.classloader;

public class MyTest7 {
    public static void main(String[] args) throws Exception {
        System.out.println(Class.forName("java.lang.String").getClassLoader());
        System.out.println(Class.forName("com.shengsiyuan.jvm.classloader.cc").getClassLoader());
    }
}

