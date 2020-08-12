package com.kgc.feign;

import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "tg-goods-provider")
public interface GoodsFeignClient {
    @RequestMapping("/getGoodsPage")
    public PageUtil<Goods> getGoodsPage(@RequestParam Map<String ,Object> parma);

    @RequestMapping("/insertGoods")
    public int insetGoods(@RequestBody Goods goods);

    @RequestMapping("/updategoods")
    public int updateGoods(@RequestBody Goods goods);

    @RequestMapping("/getGoodsById/{goodsId}")
    public Goods getGoodsById(@PathVariable("goodsId") Integer goodsId);
}
