package com.demo.dynamic.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * example
 * @author 
 */
@Data
public class Example implements Serializable {
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 0=>状态0,1=>状态1,2=>状态2
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}