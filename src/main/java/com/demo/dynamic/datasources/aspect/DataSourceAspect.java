package com.demo.dynamic.datasources.aspect;

import com.demo.dynamic.datasources.DataSourceNames;
import com.demo.dynamic.datasources.DynamicDataSource;
import com.demo.dynamic.datasources.DynamicDataSourceContext;
import com.demo.dynamic.datasources.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author hens
 * @Description
 * @create 2020-10-23 13:12
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@within(com.demo.dynamic.datasources.annotation.DataSource)")
    public void dataSourcePointCut(){

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DataSource ds = AnnotationUtils.getAnnotation(method, DataSource.class);
        ds = Optional.ofNullable(ds).orElseGet(() ->{
            Class<?> declaringClass = method.getDeclaringClass();
            return AnnotationUtils.getAnnotation(declaringClass,DataSource.class);
        });
        if(ds == null){
            DynamicDataSourceContext.set(DataSourceNames.DEFAULT_DATASOURCENAMES);
        } else {
            DynamicDataSourceContext.set(ds.name());
        }
        try{
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceContext.clear();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
