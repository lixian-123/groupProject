package com.kgc.goods.service;

import com.kgc.pojo.goods.Goods;
import com.kgc.goods.mapper.Goodsmapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGoodsservice {

    @Autowired
    private Goodsmapper goodsmapper;

//    @RequestMapping("/getAllGoods")
//    public PageUtil getAllGoods(@RequestParam Map<String ,Object> parma){
//        PageUtil page=new PageUtil();
//        //当前页面
//        Integer index=Integer.parseInt(parma.get("index").toString());
//        page.setPageIndex(index);
//        //每页条数
//        Integer size=Integer.parseInt(parma.get("size").toString());
//        page.setPageSize(size);
//
//        List<Goods> list=goodsmapper.getAllGoods(parma);
//        int cound=goodsmapper.count(parma);
//        page.setList(list);
//        page.setTotalCount(cound);
//        return page;
//
//
//    }

    //根据id查询商品详细信息
    @RequestMapping("/getGoodsById")
    public Goods getByid(Integer id){
        return goodsmapper.getPersonById(id);
    }
    //根据商品类别查询商品
    @RequestMapping("/getGoodsType")
    public Goods getGoodsByType(String type){
        return goodsmapper.getGoodsByType(type);
    }

    //添加商品
    @RequestMapping("/goodsAdd")
    public int getAdd(Goods goods){
        int count=goodsmapper.goodsAdd(goods);
        return count;
    }
    //删除商品
    @RequestMapping("/goodsdelete/{id}")
    public int goodsDelete(Integer id){
        return goodsmapper.goodsDelete(id);
    }
    //修改商品
    @RequestMapping("/goodsupdate")
    public int goodsUpdate(Goods goods){
        return goodsmapper.goodsUpdate(goods);
    }
}
