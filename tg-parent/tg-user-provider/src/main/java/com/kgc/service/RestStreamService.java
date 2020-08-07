package com.kgc.service;
import com.kgc.mapper.UserStreamMapper;
import com.kgc.pojo.user.UserStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestStreamService {

    @Autowired
    private UserStreamMapper userStreamMapper;

    @RequestMapping("/streamid/{id}")
    public UserStream getMemberById(@PathVariable("id") Integer id){
        return userStreamMapper.getUserStreamById(id);
    }

    @PostMapping("/streamupdate")
    public int update(@RequestBody UserStream userStream){
        return userStreamMapper.update(userStream);
    }

    @PostMapping("/stramadd")
    public int add(@RequestBody UserStream userStream){
        return userStreamMapper.add(userStream);
    }

}
