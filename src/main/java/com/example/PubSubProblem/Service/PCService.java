package com.example.PubSubProblem.Service;


import com.example.PubSubProblem.Threads.ConsumerThread;
import com.example.PubSubProblem.Threads.ProducerThread;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCService {

    private SharedResource sharedResource = new SharedResource();

    {
        Thread consumer = new Thread(new ConsumerThread(sharedResource));
        consumer.start();
        System.out.println("Consumer Thread Started Successfully");
    }

    public void produce(List<String> items){
        Thread producer = new Thread(new ProducerThread(sharedResource,items));
        producer.start();
        System.out.println("Producer Thread Started Successfully ");

    }
}
