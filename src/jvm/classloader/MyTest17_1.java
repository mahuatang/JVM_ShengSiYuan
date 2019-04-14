package jvm.classloader;

public class MyTest17_1 {

    public static void main(String[] args) throws Exception{
      //  MyTest16 loader1 = new MyTest16("loader1");
     //   loader1.setPath("/Users/yurui/Desktop/项目代码/java8/JVMLecture/out/production/JVMLecture/");
    //    Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.re.MyTest1");
    //    System.out.println("class: " + clazz.hashCode());

        /**
         * 如果注释掉该行，那么就并不会实例话MySample对象，即MySample构造方法不会得到调用，
         * 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat Class
         */
   //     Object object = clazz.newInstance();
        /*new MySample();*/
    }

}
