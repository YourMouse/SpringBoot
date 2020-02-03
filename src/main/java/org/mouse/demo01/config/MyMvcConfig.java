package org.mouse.demo01.config;

import org.mouse.demo01.component.MyHandlerInterceptor;
import org.mouse.demo01.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展mvc并且不影响springboot的自动配置
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    //首页(重定向)资源映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");   //拦下以“/”的请求去访问名为index（配上前缀后拽）界面，下同
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
    }

    //配置视图资源国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/employee/login","/css/**","/js/**","/images/**");  //配路径的时候一定要注意以斜杠开头
    }


}
