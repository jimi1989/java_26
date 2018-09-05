package com.kaishengit.blocking;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	
    private BlockingQueue<Apple> queue;
    
    public Producer(BlockingQueue<Apple> queue) {
        this.queue = queue;
    }
    
    public boolean put(Apple apple) {
    	System.out.println("生產者生產" + apple.getId());
        return queue.offer(apple);
    }

	
}
