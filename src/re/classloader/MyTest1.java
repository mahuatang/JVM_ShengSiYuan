package re.classloader;

public class MyTest1 {
    public static void main(String[] args) {
      //  MyParent myParent = new MyChild();
        System.out.println(MyChild.str1);
    }
}

class MyParent {
    public static String str1 = "MyParent static property";

    static {
        System.out.println("hello world");
    }
}

class MyChild extends MyParent {
    public static String str2 = "MyChild static property";

    static {
        System.out.println("zhanglong");
    }
}
