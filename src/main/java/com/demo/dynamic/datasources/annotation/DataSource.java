package com.demo.dynamic.datasources.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author hens
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    @AliasFor("value")
    String name() default "";
    @AliasFor("name")
    String value() default "";
}
