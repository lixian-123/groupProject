package com.kgc.goods.feign;

import com.kgc.pojo.goods.Goods;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "my-provider",fallback = GoodsFeignimpl.class)
public interface GoodsFeign {

    // 分页查询
    // @RequestMapping("/getAllGoods")
    // public List<Goods> getAllGoods(Map<String, Object> parma);




    //根据id查询商品详细信息
    @RequestMapping("/getGoodsById")
    public Goods getPersonById(Integer id);

    //根据商品类别查询商品
    @RequestMapping("/getGoodsType")
    public Goods getGoodsByType(String type);

    //添加商品
    @RequestMapping("/goodsAdd")
    public int goodsAdd(Goods goods);

    //删除商品
    @RequestMapping("/goodsdelete/{id}")
    public int goodsDelete(Integer id);

    //修改商品
    @RequestMapping("/goodsupdate")
    public int goodsUpdate(Goods goods);
}
