package classloader;

public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }
    public static void main(String[] args) {
        System.out.println(Child.a);
    }
}

class Parent {
    static {
        System.out.println("Parent static block");
    }
    public static int a = 3;
}

class Child extends Parent {
    static {
        System.out.println("Child static block");
    }
    public static int b = 4;
}
