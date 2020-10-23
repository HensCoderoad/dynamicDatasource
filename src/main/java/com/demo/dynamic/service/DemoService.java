package com.demo.dynamic.service;

import com.demo.dynamic.entity.Example;
import com.demo.dynamic.mapper.ExampleDao;
import com.demo.dynamic.mapper.MoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hens
 * @Description
 * @create 2020-10-23 14:12
 */
@Service
public class DemoService {
    @Autowired
    private ExampleDao exampleDao;
    @Autowired
    private MoodDao moodDao;

    public void test(){
        System.out.println(moodDao.selectByPrimaryKey(1L));
    }

    public void test1(){
        System.out.println(exampleDao.selectByPrimaryKey(1));
    }
}
