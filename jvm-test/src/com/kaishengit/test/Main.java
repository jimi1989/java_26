package com.kaishengit.test;

public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        //-Xms20m -Xmx20M -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
        byte[] bytes = null;
        for (int i = 0;i < 5;i++) {
            bytes = new byte[1024*1024*1];

            // -Xms5m -Xmx10M -XX:+PrintGCDetails -XX:+UseSerialGC
            System.out.println("可用最大内存： " + runtime.maxMemory());
            System.out.println("空闲内存： " + runtime.freeMemory());
            System.out.println("当前可用内存： " + runtime.totalMemory());

        }



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
