package com.kgc.service;

import com.kgc.mapper.GoodsMapper;
import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class RestGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping("/getGoodsPage")
    public PageUtil<Goods> getGoodsPage(@RequestParam Map<String ,Object> parma){
        PageUtil page=new PageUtil();
        page.setPageIndex(Integer.parseInt(parma.get("index").toString()));
        page.setPageSize(Integer.parseInt(parma.get("size").toString()));
        page.setTotalCount(goodsMapper.getCount(parma));
        List<Goods> list=goodsMapper.getGoodByPage(parma);

        page.setList(goodsMapper.getGoodByPage(parma));
        page.setList(list);
        return page;
    }

    @RequestMapping("/insertGoods")
    public int insetGoods(@RequestBody Goods goods){
        return goodsMapper.insertGoods(goods);
    }

    @RequestMapping("/updategoods")
    public int updateGoods(@RequestBody Goods goods){
        return goodsMapper.updateGoods(goods);
    }

    @RequestMapping("/getGoodsById/{goodsId}")
    public Goods getGoodsById(@PathVariable("goodsId") Integer goodsId){
        return goodsMapper.getGoodsById(goodsId);
    }


}