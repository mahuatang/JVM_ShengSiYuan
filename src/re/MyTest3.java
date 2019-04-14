package re;

import java.util.UUID;

public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.random);
    }
}

class MyParent3 {
    public static String random = UUID.randomUUID().toString();

    static {
        System.out.println("public static block");
    }
}
