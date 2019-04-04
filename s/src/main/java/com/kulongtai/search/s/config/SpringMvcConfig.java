package com.kulongtai.search.s.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Title: SpringMvcConfig
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 16:32
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer{
	@Override public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
				.maxAge(3600);
	}


}
