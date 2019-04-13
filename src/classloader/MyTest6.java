package classloader;

public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(Singleton.count1);
        System.out.println(Singleton.count2);
    }
}

class Singleton {
    public static int count1;
    public static int count2 = 0;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}