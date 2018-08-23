package com.bbz.spring.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@RestController
@ServletComponentScan("com.bbz.spring.demo")
@MapperScan("com.bbz.spring.demo.mapper")
@EnableCaching
public class DemoApplication implements ServletContextInitializer {
    @Value("${com.bbz.spring.user.name}")
    private String userName;

    @Value("${com.bbz.spring.user.password}")
    private String password;

    @RequestMapping("/")
    String index() {
        return "index111";
    }

    @RequestMapping("/name")
    String name() {
        return userName + "," + password;
    }

    @RequestMapping("/doError")
    String err() {
        int[] ints = new int[3];
        int i = ints[4];
        return i + "";

    }

    @RequestMapping("/home")
    String home() {
        return "Hello Spring World!";
    }

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        SpringApplication app = new SpringApplication(DemoApplication.class);
        ApplicationListener<?> listener = (ApplicationListener<ApplicationEvent>) event ->
                System.out.println("event class is " + event.getClass().getCanonicalName());
        app.addListeners(listener);

        app.setBannerMode(Banner.Mode.OFF);
//        app.setListeners(new L);
        app.run(args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

//        servletContext.
    }
}
