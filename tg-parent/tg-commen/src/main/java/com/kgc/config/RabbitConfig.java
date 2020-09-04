package com.kgc.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //声明队列ceshi
    public static final String QUEUE_Email="email";
    public static final String QUEUE_SMS="sms";
    //声明交换机
    public static final String EXCHANGE="TGExchangeTopics";
    public static final String LMEXCHANGE="LMExchangeTopics";

    @Bean(EXCHANGE)
    public Exchange createExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build();
    }
    @Bean(LMEXCHANGE)
    public Exchange createLmExchange(){
        return ExchangeBuilder.topicExchange(LMEXCHANGE).durable(true).build();
    }

    @Bean(QUEUE_SMS)
    public Queue createSMSQueue(){
        Queue queue=new Queue("tg");
        return queue;
    }
    @Bean(QUEUE_Email)
    public Queue createLMQueue(){
        Queue queue=new Queue("lm");
        return queue;
    }

    @Bean
    public Binding bindingSMS(@Qualifier(EXCHANGE)Exchange exchange,@Qualifier(QUEUE_SMS)Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.sms.#").noargs();
    }

    @Bean
    public Binding bindingLMSMS(@Qualifier(LMEXCHANGE)Exchange exchange,@Qualifier(QUEUE_Email)Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.email.#").noargs();
    }
}
