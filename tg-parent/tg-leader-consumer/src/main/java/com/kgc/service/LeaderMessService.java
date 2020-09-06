package com.kgc.service;

import com.kgc.pojo.leader.Leader_mess;
import com.kgc.util.PageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface LeaderMessService {

    public PageUtil<Leader_mess> getMessPage(Integer index,Integer size,Integer LeaderId);

    public int insertMess(Leader_mess mess);

    public Leader_mess getMessById(Integer id);

    public int updateMess(Leader_mess mess);

    public int delMess(Integer id);

    public List<Leader_mess> getAllMess(Integer LeaderId);
}
