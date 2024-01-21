package com.saude.beneficiario.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CorsConfiguration implements WebMvcConfigurer {

	@Value("${application.security.cors-origin}")
	private String[] cors;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
		.addMapping("/**")
		.allowedOrigins(cors)				
		.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
		.allowedHeaders("*")
		.exposedHeaders("USER").allowCredentials(true);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}