package com.kgc.mapper;

import com.kgc.pojo.user.Custodian;
import org.apache.ibatis.annotations.Mapper;



public interface CustodianMapper {

    //分页
    //public List<Custodian> getAllCustodian(Map<String, Object> param);
    //public  int getCount(Map<String, Object> param);

    //根据ID查询所有信息
    public Custodian getCustodianById(Integer id);

    //更新数据
    public int update(Custodian custodian);

    //添加
    public int add(Custodian custodian);

    //删除
    public int delete(Integer id);

}
