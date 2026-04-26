package com.example.PubSubProblem.Service;


import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class SharedResource{

        private Queue<String> queue = new LinkedList<>();
        private int capacity = 5;

        public synchronized void produceItem(String item) throws InterruptedException {
            while (queue.size() == capacity) {
                System.out.println("Producer Thread is Waiting because queue size is full");
                wait();
            }
                queue.add(item);
                notifyAll();
        }

        public synchronized void consumeItem() throws InterruptedException {
            while (queue.isEmpty()) {
                System.out.println("Consumer Thread is Waiting");
                wait();
            }
            String item = queue.poll();
            System.out.println(item);
            notifyAll();
        }

}
