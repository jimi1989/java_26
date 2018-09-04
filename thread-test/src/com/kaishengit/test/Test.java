package com.kaishengit.test;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		Bank bank = new Bank();

		ThreadA a = new ThreadA(bank);
		ThreadB b = new ThreadB(bank);
		a.start();
		b.start();
		
		/*Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("t1-->" + i);
				}
			}
			
		});
		
		
		t1.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("main:-->" +i );
		}
		
		*/

		
		/*Class clazz = Account.class;
		
		Object obj = clazz.newInstance();*/
		
		// System.out.println(obj.getClass().getName());
		
		/*Field field = clazz.getDeclaredField("id");
		field.setAccessible(true);
		System.out.println(field.getName());
		System.out.println(field.getInt(obj));*/
		
		/*Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}*/
		
		
	}
	
}
