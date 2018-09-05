package com.kaishengit.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread{

	private List<String> buffer;

    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            //调用exchange()与消费者进行数据交换
            try {
            	TimeUnit.SECONDS.sleep(1);
            	buffer =  exchanger.exchange(buffer);
                System.out.println("消费者交换完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("消费者第" + i + "次提取");
            for (int j = 1; j <= 3 ; j++) {
                System.out.println("消费者 : " + buffer.get(0));
                buffer.remove(0);
            }
        }
    }

}
