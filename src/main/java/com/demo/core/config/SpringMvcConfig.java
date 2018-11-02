package com.demo.core.config;

import com.demo.core.common.MyConfiguration;
import com.demo.core.common.SessionCheckInterceptor;
import com.demo.core.common.SpringApp;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.IOException;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(value={"com.demo.dao","com.demo.service","com.demo.controller"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MyConfiguration configBean(){
        MyConfiguration config =  new MyConfiguration();
        config.setLocation(SpringApp.getInstance().getResource("classpath:conf/db.properties"));
        return config;
    }

    @Bean
    public SessionCheckInterceptor sessionCheckInterceptor(){
        return new SessionCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionCheckInterceptor());
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/main/**").addResourceLocations("/WEB-INF/templates/main/");
        registry.addResourceHandler("/WEB-INF/templates/*").addResourceLocations("/WEB-INF/templates/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toIndex").setViewName("index");
    }


    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(MyConfiguration.getProperty("jdbc.driver_name"));
        dataSource.setUrl(MyConfiguration.getProperty("jdbc.driver_url"));
        return dataSource;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        try {
            factoryBean.setMapperLocations(SpringApp.getInstance().getResources(MyConfiguration.getProperty("mapper_location")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factoryBean;
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(){
        SqlSessionTemplate sql = null;
        try {
            sql = new SqlSessionTemplate(sqlSessionFactoryBean().getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sql;
    }

}
