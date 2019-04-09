package re.classloader;

import java.util.Random;

public class MyTest5 {
    public static void main(String[] args) {
      //  System.out.println(MyChild5.b);
        new C();
        new C();
    }
}

interface MyParent5 {
    public static final int a = new Random().nextInt(6);

    public static final Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

interface MyChild5 extends MyParent5 {
    public static final int b = 6;
}

class C {
    static {
        System.out.println("wo kao");
    }
    {
        System.out.println("C haha");
    }

    public C() {
        System.out.println("C()");
    }
}
