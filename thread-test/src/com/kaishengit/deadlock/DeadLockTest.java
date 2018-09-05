package com.kaishengit.deadlock;

public class DeadLockTest {
	
	public static void main(String[] args) {
		
		DeadLock deadLock = new DeadLock();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				deadLock.leftRight();
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				deadLock.leftRight();
			}
			
		});
		
		t1.start();
		t2.start();
		
	}
	
	
	
}
