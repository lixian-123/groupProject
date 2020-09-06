package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.mapper.GoodsMapper;
import com.kgc.pojo.goods.Goods;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.util.PageUtil;
import com.kgc.util.RedisUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class RestGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    RedisUtils redisUtils;

    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient client;

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

    //从redis中根据key得到团购信息得到库存余量
    @RequestMapping("/checkNumberTeam")
    public int checkNumberTeam(@RequestParam("goodsId") Integer goodsId){
        String key="TeamGoods_"+goodsId;
        String TeamJson=redisUtils.get(key).toString();
        TeamOrder teamOrder= JSON.parseObject(TeamJson,TeamOrder.class);
        int num=teamOrder.getGoodsNumber();
        return num;
    }

    //保存商品信息到es
    @RequestMapping("/insertGoodsToEs")
    public void insertGoodsToEs()throws Exception{
        BulkRequest bulkRequest=new BulkRequest();
        List<Goods> goodsList=goodsMapper.getAllGoods();
        for (int i = 0; i < goodsList.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("order_index")
                            .id(""+i+1)
                            .source(JSON.toJSONString(goodsList.get(i)), XContentType.JSON)
            );
            client.bulk(bulkRequest,RequestOptions.DEFAULT);
        }
    }
}
}

