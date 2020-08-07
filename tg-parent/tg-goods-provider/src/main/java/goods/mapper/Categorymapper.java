package goods.mapper;


import com.kgc.pojo.goods.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Categorymapper {
    //查询所有商品类别
    public List<Category> getAllCate();
}
