package com.demo.dynamic.datasources;

/**
 * @author hens
 * @Description
 * @create 2020-10-23 13:20
 */
public interface DataSourceNames {

    String DEFAULT_DATASOURCENAMES = DataSourceNames.MASTER_DATASOURCE;

    String MASTER_DATASOURCE = "spring.datasource.master";

    String SLAVE_DATASOURCE = "spring.datasource.slave";
}
