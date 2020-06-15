package com.jstu.serve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author 呆居
 */
@SpringBootApplication
public class YyServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(YyServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(YyServerApplication.class);
    }

}
