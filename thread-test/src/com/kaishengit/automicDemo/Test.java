package com.kaishengit.automicDemo;

/**
 * @author jinjianghao
 * @date 2018/9/4
 */
public class Test {

    public static void main(String[] args) {
        AutomicDemo automicDemo = new AutomicDemo();
        for(int i = 0; i < 100; i++) {
            Thread t1 = new Thread(automicDemo);
            t1.start();
        }


    }

}
