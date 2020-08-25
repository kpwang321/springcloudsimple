package com.kpwang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author kpwang
 * @create 2020-08-25 2:07
 */
//@Configuration
public class TkMapperConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.kpwang.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        Properties properties=new Properties();
        properties.put("mappers","tk.mybatis.mapper.common.Mapper");
        properties.put("ORDER","BEFORE");

        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
