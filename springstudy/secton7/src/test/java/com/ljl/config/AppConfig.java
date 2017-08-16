package com.ljl.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/8/14/014.
 */
@Configuration
//@ComponentScan(basePackages = "ljl")
public class AppConfig {
    @Bean(name="myservice1")
    @Scope(value="prototype",proxyMode= ScopedProxyMode.TARGET_CLASS)
   public MyService getMyService(){
        return new MyServiceImpl();
    }
    @Bean(name = { "dataSource", "subsystemA-dataSource", "subsystemB-dataSource" })
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
