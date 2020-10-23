package com.demo.dynamic.mapper;

import com.demo.dynamic.entity.Example;
import com.demo.dynamic.datasources.DataSourceNames;
import com.demo.dynamic.datasources.annotation.DataSource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DataSource(name = DataSourceNames.MASTER_DATASOURCE)
public interface ExampleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Example record);

    int insertSelective(Example record);

    Example selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Example record);

    int updateByPrimaryKey(Example record);
}