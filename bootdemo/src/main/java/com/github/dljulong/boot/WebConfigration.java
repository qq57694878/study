package com.github.dljulong.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2019/3/25 0025.
 */
@Configuration
public class WebConfigration  implements WebMvcConfigurer{
    @Autowired
    private RestInterceptor restInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restInterceptor).addPathPatterns("/**/*").excludePathPatterns("/static/*");
    }
}
