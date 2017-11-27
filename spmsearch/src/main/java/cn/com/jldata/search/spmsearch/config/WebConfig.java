package cn.com.jldata.search.spmsearch.config;

import cn.com.jldata.search.spmsearch.converter.DateConverter;
import cn.com.jldata.search.spmsearch.converter.JsonMapper;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/*@Configuration
@EnableWebMvc // 启用 SpringMVC ，相当于 xml中的 <mvc:annotation-driven/>
@ComponentScan(basePackages = {"cn.com.jldata.solrdemo.**.controller"},
        includeFilters = @ComponentScan.Filter(classes = Controller.class),
        useDefaultFilters = false)*/
public class WebConfig extends WebMvcConfigurerAdapter {

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
     * 配置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .maxAge(1800);
    }

}