package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.config.RabbitConfig;
import com.kgc.mapper.OrderDetailMapper;
import com.kgc.pojo.order.OrderDetail;
import com.kgc.vo.Dto;
import com.kgc.vo.DtoUtil;
import com.kgc.vo.MqMessVo;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Order")
public class RestOrderService {
    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient client;
    @Autowired
    OrderDetailMapper detailMapper;
    @RequestMapping("/addOrderEs")
    public void addOrderEs() throws IOException {
        BulkRequest bulkRequest=new BulkRequest();
        List<OrderDetail> list=detailMapper.getAllDetail();
        for (int i = 0; i < list.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("order_index")
                            .id(""+i+1)
                            .source(JSON.toJSONString(list.get(i)), XContentType.JSON)
            );
            client.bulk(bulkRequest, RequestOptions.DEFAULT);
        }
    }
}
