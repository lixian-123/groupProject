package com.kgc.service;

import com.kgc.pojo.user.Leader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface LeaderService {

    public Leader getleaderLogin(@RequestParam Map<String,Object> param);

    public Leader getLeaderById(@PathVariable("id") Integer id);

    public int update( @RequestBody Leader leader);

    public int add(@RequestBody Leader leader);

    public int delete(@PathVariable("id") Integer id);

}
