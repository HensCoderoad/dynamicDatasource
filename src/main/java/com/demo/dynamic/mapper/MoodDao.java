package com.demo.dynamic.mapper;

import com.demo.dynamic.datasources.DataSourceNames;
import com.demo.dynamic.datasources.annotation.DataSource;
import com.demo.dynamic.entity.Mood;
import org.apache.ibatis.annotations.Mapper;
@Mapper
@DataSource(name = DataSourceNames.SLAVE_DATASOURCE)
public interface MoodDao {
    int deleteByPrimaryKey(Long id);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}