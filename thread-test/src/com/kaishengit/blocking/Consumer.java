package com.kaishengit.blocking;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

	private BlockingQueue<Apple> queue;
    
    public Consumer(BlockingQueue<Apple> queue) {
        this.queue = queue;
    }
    
    public Apple take() throws InterruptedException {
        return queue.take();
    }

	

}
