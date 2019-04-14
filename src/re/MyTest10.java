package re;

public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2;

        System.out.println("------------");

        parent2 = new Parent2();

        System.out.println("-------------");

        System.out.println(parent2.a);

        System.out.println("-------------");

        System.out.println(Child2.b);
    }
}

class Parent2 {
    public static int a = 3;
    static {
        System.out.println("Parent2 staitc block");
    }
}

class Child2 extends Parent2 {
    public static int b = 4;
    static {
        System.out.println("Child2 static block");
    }
}
