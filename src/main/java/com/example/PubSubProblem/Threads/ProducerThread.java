package com.example.PubSubProblem.Threads;

import com.example.PubSubProblem.Service.SharedResource;

import java.util.List;

public class ProducerThread implements Runnable{

    private SharedResource sharedResource;
    private List<String> items;

    public ProducerThread(SharedResource sharedResource, List<String> items){
        this.sharedResource = sharedResource;
        this.items = items;
    }

    @Override
    public void run() {

        for(String s : items){
            try {
                sharedResource.produceItem(s);
//                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
