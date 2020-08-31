package com.kgc.service;

import com.kgc.config.RabbitConfig;
import com.kgc.vo.Dto;
import com.kgc.vo.DtoUtil;
import com.kgc.vo.MqMessVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/Order")
public class RestOrderService {

}
