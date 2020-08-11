package com.kgc.service.impl;

import com.kgc.Feign.StreamFeignClient;
import com.kgc.pojo.user.UserStream;
import com.kgc.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    private StreamFeignClient streamFeignClient;

    @Override
    public UserStream getMemberById(Integer id) {
        return streamFeignClient.getMemberById(id);
    }

    @Override
    public int update(UserStream userStream) {
        return streamFeignClient.update(userStream);
    }

    @Override
    public int add(UserStream userStream) {
        return streamFeignClient.add(userStream);
    }
}
