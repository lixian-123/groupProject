package com.kgc.service;

import com.kgc.pojo.user.UserStream;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface StreamService {

    public UserStream getMemberById(@PathVariable("id") Integer id);

    public int update(@RequestBody UserStream userStream);

    public int add(@RequestBody UserStream userStream);
}
