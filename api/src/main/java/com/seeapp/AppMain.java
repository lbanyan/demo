package com.seeapp;

import com.seeapp.component.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;

/**
 * 启动入口
 *
 * @author zhuhui
 */
public class AppMain {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(ApplicationConfiguration.class);
        application.run(args);
    }
}
