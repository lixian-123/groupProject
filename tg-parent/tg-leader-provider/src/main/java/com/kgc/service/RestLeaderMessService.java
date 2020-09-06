package com.kgc.service;

import com.kgc.mapper.Leader_messMapper;
import com.kgc.pojo.goods.Goods;
import com.kgc.pojo.leader.Leader_mess;
import com.kgc.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RestLeaderMessService {

    @Resource
    private Leader_messMapper messMapper;

    @RequestMapping("/getMessPage")
    public PageUtil<Leader_mess> getMessPage(@RequestParam Map<String,Object> map){
        PageUtil page=new PageUtil();
        page.setPageIndex(Integer.parseInt(map.get("index").toString()));
        page.setPageSize(Integer.parseInt(map.get("size").toString()));
        page.setList(messMapper.getAllMessPage(map));
        page.setTotalCount(messMapper.getCount(map));
        return page;
    }

    @RequestMapping("/insertMess")
    public int insertMess(@RequestBody Leader_mess mess){
        return messMapper.addMess(mess);
    }

    @RequestMapping("/getMessById/{id}")
    public Leader_mess getMessById(@PathVariable("id") Integer id){
       return messMapper.getMessById(id);
    }

    @RequestMapping("/updateMess")
    public int updateMess(@RequestBody Leader_mess mess){
        return messMapper.updateMess(mess);
    }

    @RequestMapping("/delMess/{id}")
    public int delMess(@PathVariable("id") Integer id){
        return messMapper.delMess(id);
    }

    @RequestMapping("/getAllMess/{LeaderId}")
    public List<Leader_mess> getAllMess(@PathVariable("LeaderId") Integer LeaderId){
        return messMapper.getAllMess(LeaderId);
    }
}
