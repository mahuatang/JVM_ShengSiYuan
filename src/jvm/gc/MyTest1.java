package jvm.gc;

/**
 * 5646-624=5022k //执行完gc后，新生代释放的空间容量
 * 5646-4728=918  //执行完gc后，总的堆空间释放的容量
 *
 * 5022-918=4104：经过这次垃圾回收后，新生代晋升到老年代的对象
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[2 * size];

        System.out.println("hello world");
    }
}
