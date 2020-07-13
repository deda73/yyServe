package com.jstu.serve.common;


import com.jstu.serve.cache.Good;
import com.jstu.serve.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AfterTest implements CommandLineRunner {

    @Autowired
    TestService testService;

    @Override
    public void run(String... args) throws Exception {
        int count = testService.getGoodCount(1);
        Good.GoodCount = count;
    }
}
