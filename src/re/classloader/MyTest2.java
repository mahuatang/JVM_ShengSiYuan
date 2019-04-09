package re.classloader;

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.d);
    }
}

class MyParent2 {
    public static final String str = "a";
    public static final int a = 1;
    public static final char c = 'a';
    public static final long d = 1341325L;

    static {
        System.out.println("HAHAHAHAHA");
    }
}
