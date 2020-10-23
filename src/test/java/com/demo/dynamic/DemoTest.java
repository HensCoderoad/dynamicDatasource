package com.demo.dynamic;

import com.demo.dynamic.mapper.ExampleDao;
import com.demo.dynamic.mapper.MoodDao;
import com.demo.dynamic.service.DemoService;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hens
 * @Description
 * @create 2020-10-23 14:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void master(){
        demoService.test1();
    }

    @Test
    public void slave(){
        demoService.test();
    }
}
