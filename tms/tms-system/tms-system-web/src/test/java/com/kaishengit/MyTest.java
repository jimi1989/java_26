package com.kaishengit;

import org.junit.Test;

/**
 * @Author: chuzhaohui
 * @Date: Created in 9:43 2018/8/29
 */
public class MyTest {

    @Test
    public void testA(){
        System.out.println(SubClass.a);
    }
    @Test
    public void testB(){
        System.out.println(SubClass.b);
    }
    @Test
    public void testC(){
        System.out.println(SubClass.c);
    }
    @Test
    public void testD(){
        System.out.println(SubClass.d);
    }
    @Test
    public void testE(){
        System.out.println(SubClass.e);
    }
    @Test
    public void testF(){
        System.out.println(SubClass.f);
    }

}
class SupClass{
    static int a = 10;
    static final int b = 20;
    static{
        System.out.println("SupClass init ...");
        a = 100;
    }
}

class SubClass extends SupClass{
    static int c = a;
    static int d = b;
    static final int e = a;
    static final int f = b;
    static{
        System.out.println("SubClass init ...");
    }
}