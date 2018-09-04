package com.kaishengit.test;

public class ThreadA extends Thread{

	private Bank bank;
	
	public ThreadA(Bank bank) {
		this.bank = bank;
	}
	
	
	@Override
	public void run() {
		
		/*for(int i = 1; i > 0; i++) {
			System.out.println("----------" + i);
		}*/
		bank.pickMoney();
		
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		// System.out.println("--------A end--------");
		
	}
	
}
