package com.kgc.controller;

import com.kgc.pojo.user.UserStream;
import com.kgc.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StreamController {

    @Autowired
    private StreamService streamService;


    @RequestMapping("/streamid/{id}") //已测
    public UserStream getMemberById(@PathVariable("id") Integer id){
        return streamService.getMemberById(id);
    }

    @PostMapping("/streamupdate") //已测
    public int update(@RequestBody UserStream userStream){
        return streamService.update(userStream);
    }

    @PostMapping("/stramadd") //已测
    public int add(@RequestBody UserStream userStream){
        return streamService.add(userStream);
    }

}
