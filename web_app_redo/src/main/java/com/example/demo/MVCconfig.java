package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@EnableWebMvc
@Configuration
public class MVCconfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/greeting").setViewName("greeting");
    }

    @Configuration
    @EnableWebMvc
    public class MvcConfiguration extends WebMvcConfigurerAdapter{
        @Bean
        public ViewResolver getViewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/resources/templates/");
            resolver.setSuffix(".html");
            return resolver;
        }

        @Override
        public void configureDefaultServletHandling(
                DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        @Bean
        public ViewResolver resourceBundleViewResolver() {
            ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
            bean.setBasename("views");
            return bean;
        }
    }
}
