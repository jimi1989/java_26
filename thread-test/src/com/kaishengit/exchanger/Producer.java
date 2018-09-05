package com.kaishengit.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Producer extends Thread{
	
	//生产者、消费者交换的数据结构
    private List<String> buffer;

    //步生产者和消费者的交换对象
    private Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer,Exchanger<List<String>> exchanger){
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for(int i = 1 ; i < 5 ; i++){
            System.out.println("生产者第" + i + "次提供");
            for(int j = 1 ; j <= 3 ; j++){
                System.out.println("生产者装入" + i  + "--" + j);
                buffer.add("buffer：" + i + "--" + j);
            }

            System.out.println("生产者装满，等待与消费者交换...");
            try {
            	TimeUnit.SECONDS.sleep(1);
                exchanger.exchange(buffer);
                System.out.println("生产者交换完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

	
}
