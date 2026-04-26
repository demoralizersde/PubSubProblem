package com.example.PubSubProblem.Controller;


import com.example.PubSubProblem.Service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PubSubController {


    @Autowired
    PCService pcService;
    @PostMapping("/produce")
    public String addItem(@RequestBody List<String> list){
        if(list.size() >= 10){
            return "Max Limit 10 allowed";
        }
        pcService.produce(list);
        return "Done Successfully";
    }
}
