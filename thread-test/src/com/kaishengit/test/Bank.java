package com.kaishengit.test;

public class Bank {

	public void pickMoney() {
		try {
			synchronized(this) {
				// 获得当前线程的名称  默认 Thread-0  Thread-1
				System.out.println(Thread.currentThread().getName() + " start");
				for(int i = 0; i < 100; i++) {
					if(i == 30) {
						if(Thread.currentThread().getName().equals("Thread-0")) {
						    System.out.println("sleeping...");
						    this.wait();
						}
					}
					System.out.println(Thread.currentThread().getName() + "----------" + i);
				}
				System.out.println(Thread.currentThread().getName() +  " end");
				if(Thread.currentThread().getName().equals("Thread-1")) {
					this.notify();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
