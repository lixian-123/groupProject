package com.kgc.service;

import com.kgc.pojo.leader.Leader_sale;
import com.kgc.util.PageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface LeaderSaleService {

    public PageUtil getSalePage(Integer index,Integer size,Integer LeaderId);

    public int addSale(Leader_sale leader_sale);

    public Leader_sale getSaleById(Integer id);

    public int updateSale(Leader_sale leader_sale);

    public String getTichengToday();

    public String getTichengMonth();

}
