package com.kgc.Feign.impl;

import com.kgc.Feign.StreamFeignClient;
import com.kgc.pojo.user.UserStream;
import org.springframework.stereotype.Component;

@Component
public class StreamFeignClientImpl implements StreamFeignClient {
    @Override
    public UserStream getMemberById(Integer id) {
        return null;
    }

    @Override
    public int update(UserStream userStream) {
        return 0;
    }

    @Override
    public int add(UserStream userStream) {
        return 0;
    }
}
