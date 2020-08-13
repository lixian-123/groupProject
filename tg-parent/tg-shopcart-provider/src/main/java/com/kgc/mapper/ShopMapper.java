package com.kgc.mapper;

import com.kgc.pojo.shops.ShopCar;

public interface ShopMapper {

    //查看购物车信息
    public ShopCar getShopById(Integer id);

    //添加购物车
    public int add(ShopCar shopCar);

    //修改购物车信息
    public int update(ShopCar shopCar);

    //删除购物车信息
    public int delete(Integer id);

}
