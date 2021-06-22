package com.fresco.codelab.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class RequestAppConfig implements WebMvcConfigurer {
	
	
	
	private CustomRequestInterceptor customRequestInterceptor ; 

    @SuppressWarnings("unused")
    public void Config() {
    }

    @Autowired
    public void setHandlerInterceptor(CustomRequestInterceptor handlerInterceptor) {
        this.customRequestInterceptor = handlerInterceptor;
    }


	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customRequestInterceptor);
          
    }
	
}
