package com.kaishengit.deadlock;

public class DeadLock {
	
	    private final Object left = new Object();
	    private final Object right = new Object();

	    public void leftRight() {
			// 得到left锁
	        synchronized (left) {
	        	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 得到right锁
	            synchronized (right) {
	            	System.out.println("left----->right");
	            }
	        }
	    }

	    public void rightLeft() {
			// 得到right锁
	        synchronized (right) {
	        	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 得到left锁
	            synchronized (left) {
	            	System.out.println("right----->left");
	            }
	        }
	    }

	
}