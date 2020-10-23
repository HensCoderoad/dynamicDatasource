package com.demo.dynamic.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mood
 * @author 
 */
@Data
public class Mood implements Serializable {
    private Long id;

    /**
     * 期刊内容
     */
    private String content;

    private String image;

    /**
     * 索引号
     */
    private Integer indexd;

    private Date pubdate;

    private String title;

    /**
     * 100-电影/200-音乐/300-句子
     */
    private Integer moodType;

    /**
     * 音乐地址
     */
    private String url;

    private static final long serialVersionUID = 1L;
}