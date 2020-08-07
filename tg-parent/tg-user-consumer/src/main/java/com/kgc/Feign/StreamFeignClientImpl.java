package com.kgc.Feign;

import com.kgc.pojo.user.UserStream;

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
