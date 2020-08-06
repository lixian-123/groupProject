package com.kgc.mapper;

import com.kgc.pojo.user.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

public interface MemberMapper {

    //分页
    //public List<Member> getAllMember(Map<String, Object> param);
    //public int getCount(Map<String, Object> param);

    //登陆
    public Member MemberLogin(Map<String,Object> param);

    //根据编号查
    public Member getMemberById(Integer id);

    //更新
    public int update(Member member);

    //添加
    public int add(Member member);

    //删除
    public int delete(Integer id);

}
