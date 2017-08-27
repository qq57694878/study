package com.ljl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * User : liulu
 * Date : 2016-10-7 15:36
 */
@Configuration
@PropertySource("classpath:application.properties") // 导入属性文件
@EnableAspectJAutoProxy // 相当于 xml 中的 <aop:aspectj-autoproxy/>
@EnableTransactionManagement // 开启注解事务
@ComponentScan(basePackages = {"com.ljl"}, excludeFilters = @ComponentScan.Filter(classes = Controller.class  ))
@MapperScan(basePackages = "com.ljl.dao", sqlSessionFactoryRef = "OracleSqlSessionFactory")
public class RootConfig {

    // 上面导入的属性文件中的属性会 注入到 Environment 中
    @Resource
    private Environment env;

    /**
     * 配置数据库连接池 c3p0，
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setMinIdle(Integer.valueOf(env.getProperty("pool.minPoolSize")));
        dataSource.setMaxActive(Integer.valueOf(env.getProperty("pool.maxPoolSize")));
        dataSource.setMaxWait(Integer.valueOf(env.getProperty("pool.checkoutTimeout")));
        return dataSource;
    }

    /**
     * 配置事物管理器
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    /**
     * 配置mybatis sessionFactory
     * @param dataSource
     * @return
     */
    @Bean("OracleSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ljl.entity");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver() .getResources("classpath:/mapper/**/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis-config.xml"));
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","oracle");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("autoRuntimeDialect","true");
        properties.setProperty("count","countSql");
        properties.setProperty("params","count");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        return sqlSessionFactoryBean.getObject();
    }




    @Bean
    public JdbcTemplate jdbcTemplate (DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}