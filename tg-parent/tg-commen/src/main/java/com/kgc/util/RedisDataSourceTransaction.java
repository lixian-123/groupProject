package com.kgc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import redis.clients.jedis.Transaction;

@Component
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class RedisDataSourceTransaction {
    @Autowired
    RedisUtils redisUtils;
    /**
     * 数据源事务管理器
     */
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    /**
     * 手动开启数据库事务
     */
    public TransactionStatus begin(){
        TransactionStatus transaction=dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        redisUtils.begin();//开启redis事务
        return transaction;
    }
    /**
     * 提交事务
     */
    public void commit(TransactionStatus transactionStatus) throws Exception{
        if(transactionStatus==null){
            throw new Exception("transactionStatus is null");
        }
        //支持redis和数据库事务同时提交
        dataSourceTransactionManager.commit(transactionStatus);
        redisUtils.exec();
    }
    /**
     * 回滚事务
     */
    public void rollback(TransactionStatus transactionStatus) throws Exception{
        if(transactionStatus==null){
            throw new Exception("transactionStatus is null");
        }
        dataSourceTransactionManager.rollback(transactionStatus);
        redisUtils.discard();
    }
}
