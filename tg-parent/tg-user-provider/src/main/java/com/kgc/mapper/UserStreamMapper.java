package com.kgc.mapper;
import com.kgc.pojo.user.UserStream;
import org.apache.ibatis.annotations.Mapper;



public interface UserStreamMapper {

    //分页
    //public List<UserStream> getAllUserStream(Map<String, Object> param);

    //根据编号
    public UserStream getUserStreamById(Integer id);

    //更新
    public int update(UserStream userStream);

    //添加
    public int add(UserStream userStream);

    //删除
    public int delete(Integer id);

}
