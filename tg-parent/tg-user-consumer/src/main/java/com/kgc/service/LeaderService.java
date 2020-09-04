package com.kgc.service;

import com.kgc.pojo.user.Leader;
import com.kgc.util.PageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface LeaderService {

    public PageUtil<Leader> getLeaderPage(Integer index,Integer size,String LeaaderName);
    public Leader getleaderLogin(String nickname,String passWord);

    public Leader getLeaderById(@PathVariable("id") Integer id);

    public int update( @RequestBody Leader leader);

    public int add(@RequestBody Leader leader);

    public int delete(@PathVariable("id") Integer id);

}
