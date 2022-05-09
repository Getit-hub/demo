package com.sww.config;

import com.sww.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    //添加资源处理器 处理器根据url处理对应的资源
    //这些处理器也是处理器 相当于controller中的处理器方法，不过资源处理器是处理静态资源的，只是用来处理静态url请求的。
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        //根据资源处理器注册器生成一个对应资源的资源处理器，并添加处理资源的路径
    }

    //访问/books资源时进行拦截 调用拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
        //根据拦截器注册器生成一个拦截器，拦截对应的urlPath
    }
    //拦截器相当于在对应的处理器处理之前进行了拦截，使用preHandle()拦截处理之后，然后处理器去处理请求，处理完之后，执行postHandle()方法请求，
    //最后执行afterCompletion()方法
   /* @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }*/
}
