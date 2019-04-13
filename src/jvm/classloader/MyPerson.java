package jvm.classloader;

public class MyPerson {
    private MyPerson myPerson;

    static {
        System.out.println("WOOO");
    }

    public void setMyPerson(Object object) {
        System.out.println("setMyPerson invoked");
        this.myPerson = (MyPerson)object;
    }
}
