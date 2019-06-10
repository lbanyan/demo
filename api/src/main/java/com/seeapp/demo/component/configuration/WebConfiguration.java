package com.seeapp.demo.component.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WEB配置
 *
 * @author zhuhui
 */
@Configuration
@ServletComponentScan(basePackages = "com.seeapp.demo.servlet")
@ConditionalOnWebApplication
public class WebConfiguration extends WebMvcConfigurerAdapter {

}
