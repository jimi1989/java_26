package com.kaishengit.test;

class SuperClass {
    public static int value = 10;

    static {
        value = 100;
        System.out.println("SuperClass static block");
    }
}

class SubClass extends SuperClass {
    public static int b = value;
    static {
        System.out.println("SubClass static block");
    }
}

public class Main {

    public static void main(String[] args) {

        // 类加载器
        ClassLoader loader = Main.class.getClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

        // System.out.println(SubClass.b);

        // System.out.println(SuperClass.value);

        //SuperClass[] supers = new SuperClass[5];

        // System.out.println(SubClass.value);



        /*Runtime runtime = Runtime.getRuntime();

        //-Xms20m -Xmx20M -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
        byte[] bytes = null;
        for (int i = 0;i < 5;i++) {
            bytes = new byte[1024*1024*1];

            // -Xms5m -Xmx10M -XX:+PrintGCDetails -XX:+UseSerialGC
            System.out.println("可用最大内存： " + runtime.maxMemory());
            System.out.println("空闲内存： " + runtime.freeMemory());
            System.out.println("当前可用内存： " + runtime.totalMemory());

        }*/



        /*System.out.println("-------------------------------------------");
        byte[] bytes = new byte[1024*1024*4];
        System.out.println("可用最大内存： " + runtime.maxMemory());
        System.out.println("空闲内存： " + runtime.freeMemory());
        System.out.println("当前可用内存： " + runtime.totalMemory());

        System.out.println("-------------------------------------------");
        bytes = new byte[1024*1024*4];
        System.out.println("可用最大内存： " + runtime.maxMemory());
        System.out.println("空闲内存： " + runtime.freeMemory());
        System.out.println("当前可用内存： " + runtime.totalMemory());
*/
    }
}
