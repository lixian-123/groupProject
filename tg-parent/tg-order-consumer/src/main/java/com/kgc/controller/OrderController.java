package com.kgc.controller;

import com.kgc.config.ElastricSearchConfig;
import com.kgc.servie.OrderService;
import com.kgc.vo.Dto;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient client;
    @Resource
    OrderService orderService;
    @RequestMapping("/UserMess")
    public Dto userMess(@RequestParam Map<String,Object> map){
        return orderService.UserMess(map);
    }

    @PostMapping("/searchOrder")
    public List searchOrder(@RequestParam("userId")Integer userId) throws IOException {
        //批量查询请求
        SearchRequest searchRequest = new SearchRequest("order_index");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        //查询条件，精准查询
        TermQueryBuilder termQueryBuilder=new TermQueryBuilder("userId",userId);
        SearchSourceBuilder query = sourceBuilder.query(termQueryBuilder);
        //分页
        query.from(0);
        query.size(3);
        searchRequest.source(query);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        ArrayList<Map> arrayList=new ArrayList<>();
        //遍历数据存到集合中
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
            arrayList.add(hit.getSourceAsMap());
        }
        return arrayList;
    }

}
