package com.demo.dynamic.datasources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hens
 * @Description
 * @create 2020-10-23 13:25
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean(DataSourceNames.MASTER_DATASOURCE)
    @ConfigurationProperties(DataSourceNames.MASTER_DATASOURCE)
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(DataSourceNames.SLAVE_DATASOURCE)
    @ConfigurationProperties(DataSourceNames.SLAVE_DATASOURCE)
    public DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceNames.MASTER_DATASOURCE,masterDataSource());
        targetDataSources.put(DataSourceNames.SLAVE_DATASOURCE,slaveDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        return dynamicDataSource;
    }

    @Bean(name = "dynamicSqlSession")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource());
        bean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "dynamicTransation")
    public DataSourceTransactionManager setTransationManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
