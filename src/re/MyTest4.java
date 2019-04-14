package re;

public class MyTest4 {
    public static void main(String[] args) {
        MyParent4[] myParent4s = new MyParent4[2];
        MyParent4[][] myParent4s1 = new MyParent4[2][3];

        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s1.getClass());

        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("========");

        int[] ints = new int[3];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[3];
        System.out.println(chars.getClass());

        boolean[] booleans = new boolean[3];
        System.out.println(booleans.getClass());

        byte[] bytes = new byte[3];
        System.out.println(bytes.getClass());

        short[] shorts = new short[3];
        System.out.println(shorts.getClass());

    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
