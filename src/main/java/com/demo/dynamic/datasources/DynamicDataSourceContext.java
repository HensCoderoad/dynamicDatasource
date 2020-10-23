package com.demo.dynamic.datasources;

/**
 * @author hens
 * @Description
 * @create 2020-10-23 15:02
 */
public class DynamicDataSourceContext {

    private static final ThreadLocal<String> context = new ThreadLocal<String>(){
        @Override
        protected String initialValue(){
            return DataSourceNames.DEFAULT_DATASOURCENAMES;
        }
    };

    public static String get(){
        return context.get();
    }

    public static void set(String name){
        context.set(name);
    }

    public static void clear(){
        context.remove();
    }
}
