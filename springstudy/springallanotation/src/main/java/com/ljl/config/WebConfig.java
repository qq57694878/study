package com.ljl.config;

import com.ljl.auth.UserMethodArgumentResolver;
import com.ljl.auth.VersionMethodArgumentResolver;
import com.ljl.converter.JsonMapper;
import com.ljl.interceptor.JwtInterceptor;
import com.ljl.converter.DateConverter;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebMvc // 启用 SpringMVC ，相当于 xml中的 <mvc:annotation-driven/>
@ComponentScan(basePackages = {"com.ljl.**.controller"},
        includeFilters = @ComponentScan.Filter(classes = Controller.class),
        useDefaultFilters = false)
public class WebConfig extends WebMvcConfigurerAdapter {
   @Autowired
   private JwtInterceptor jwtInterceptor;
    /**
     * 设置由 web容器处理静态资源 ，相当于 xml中的<mvc:default-servlet-handler/>
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(3000);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
        jsonConverter.setDefaultCharset(Charset.forName("UTF-8"));
        jsonConverter.setObjectMapper(new JsonMapper());
        converters.add(jsonConverter);
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.jwtInterceptor).addPathPatterns()
                .addPathPatterns("/**/*")
                .excludePathPatterns("index.html","/login.*","/exclude/**/*","/static/**/*","/async-websocket/**/*","/api-docs/**/*","/monitoringv2/**/*");
    }

    /**
     * 配置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .maxAge(1800);
    }

    /**
     * 配置参数解析
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserMethodArgumentResolver());
        argumentResolvers.add(new VersionMethodArgumentResolver());
    }
}