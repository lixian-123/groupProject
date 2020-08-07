package goods.service;

import com.kgc.pojo.goods.Category;
import goods.mapper.Categorymapper;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCategoryservice {

    @Autowired
    private Categorymapper categorymapper;


    @RequestMapping("/getAllCate")
    public List<Category> getAllCate(){
        return categorymapper.getAllCate();
    }
}
