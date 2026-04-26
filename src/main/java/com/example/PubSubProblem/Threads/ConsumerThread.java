package com.example.PubSubProblem.Threads;

import com.example.PubSubProblem.Service.SharedResource;

public class ConsumerThread implements Runnable{

    private SharedResource sharedResource;

    public ConsumerThread(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedResource.consumeItem();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
