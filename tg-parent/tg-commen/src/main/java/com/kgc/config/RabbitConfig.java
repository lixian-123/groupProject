package com.kgc.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_EMAIL="email";
    public static final String QUEUE_SMS="sms";
    public static final String EXCHANGE="myexchangeTopics";

    @Bean(EXCHANGE)
    public Exchange createExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build();
    }
    @Bean(QUEUE_EMAIL)
    public Queue createEmailQueue(){
        Queue queue=new Queue(QUEUE_EMAIL);
        return queue;
    }
    @Bean(QUEUE_SMS)
    public Queue createSMSQueue(@Value("target")String target){
        Queue queue=new Queue(target);
        return queue;
    }
    @Bean
    public Binding bindingEmail(@Qualifier(EXCHANGE)Exchange exchange,@Qualifier(QUEUE_EMAIL)Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.email.#").noargs();
    }
    @Bean
    public Binding bindingSMS(@Qualifier(EXCHANGE)Exchange exchange,@Qualifier(QUEUE_SMS)Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.sms.#").noargs();
    }

}