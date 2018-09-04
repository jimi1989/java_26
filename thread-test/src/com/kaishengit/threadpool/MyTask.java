package com.kaishengit.threadpool;

public class MyTask implements Runnable {
	    private int num;

	    public MyTask(int num) {
	        this.num = num;
	    }

	    @Override
	    public void run() {
	        System.out.println("正在执行task " + num );
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("task " + num + "执行完毕");
	    }
	
}
