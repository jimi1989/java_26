package com.kaishengit.volatileDemo;

/**
 * @author jinjianghao
 * @date 2018/9/4
 * Volatile 关键字
 * 不具备原子性
 */
public class Test {

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo).start();

        while(true) {
            if(volatileDemo.isFlag()) {
                System.out.println("stop...");
                break;
            }
        }

    }

}
