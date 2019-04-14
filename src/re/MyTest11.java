package re;

public class MyTest11 {
    static {
        System.out.println("0000");
    }

    public static void main(String[] args) {
        System.out.println(Child3.a);
    }
}

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("dosomething");
    }
}

class Child3 extends Parent3{
    static {
        System.out.println("Child3 static block");
    }
}
