package com.eku001.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableCaching
public class DemoStarter {
    public static void main(String[] args) {
        SpringApplication.run(DemoStarter.class, args);
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }


    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
