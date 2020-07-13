package com.jstu.serve.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jstu.serve.cache.Good;
import com.jstu.serve.service.TestService;
import com.jstu.serve.util.AESUtil;
import com.jstu.serve.util.FormatResult;
import net.sf.json.util.JSONUtils;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 呆居
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("test")
    public List<Map<String, Object>> test() {
        return testService.testSelect();
    }

    @RequestMapping("login")
    public FormatResult login(@RequestBody Map<String, Object> map) {
        Map<String, Object> map1 = testService.login(map);
        if (map1 != null) {
            return FormatResult.ok(map1);
        } else {
            return FormatResult.build(499, "用户名或者密码有误!");
        }
    }

    @RequestMapping("updateUser")
    public FormatResult updateUser(@RequestBody Map<String, Object> map) {
        testService.updateUser(map);
        return FormatResult.ok();
    }


    @RequestMapping("getEmployee")
    public FormatResult getEmployee() {
        return FormatResult.ok(testService.getEmployeeAll());
    }

    @RequestMapping("getStore")
    public FormatResult getStore() {
        return FormatResult.ok(testService.getStoreAll());
    }

    @RequestMapping("getSupplier")
    public FormatResult getSupplier() {
        List<Map<String,Object>> list = testService.getSupplier();
        JSONArray jsonArray = new JSONArray(Collections.singletonList(list));
        String originString = jsonArray.toJSONString();
        String aesString = AESUtil.encrypt(originString);
        String finalString = AESUtil.decrypt(aesString);
        return FormatResult.ok(originString);
    }

    @RequestMapping("getRecord")
    public FormatResult getrecord() {
        return FormatResult.ok(testService.getRecord());
    }

    @RequestMapping("updateRecord")
    public FormatResult updateRecord(@RequestBody Map<String, Object> map) {
        testService.updateRecord(map);
        return FormatResult.ok();
    }

    @RequestMapping("getStoreAll")
    public FormatResult getStoreAll() {
        return FormatResult.ok(testService.getStore());
    }

    @RequestMapping("getKindCount")
    public FormatResult getKindCount() {
        return FormatResult.ok(testService.getKindCount());
    }


    @RequestMapping("getStoreAddress")
    public FormatResult getStoreAddress() {
        return FormatResult.ok(testService.getStoreAddress());
    }

    @RequestMapping("addStore")
    public FormatResult addStore(@RequestBody Map<String, Object> map) {
        testService.addStore(map);
        return FormatResult.ok();
    }

    @RequestMapping("addEmployee")
    public FormatResult addEmployee(@RequestBody Map<String, Object> map) {
        testService.addEmployee(map);
        return FormatResult.ok();
    }

    @RequestMapping("addSupplier")
    public FormatResult addSupplier(@RequestBody Map<String, Object> map) {
        testService.addSupplier(map);
        return FormatResult.ok();
    }

    @RequestMapping("addApplication")
    public FormatResult addApplication(@RequestBody Map<String, Object> map) {
        testService.addApplication(map);
        return FormatResult.ok();

    }

    @RequestMapping("getApplication")
    public FormatResult getApplication() {
        return FormatResult.ok(testService.getApplication());
    }

    @RequestMapping("handleApplication")
    public FormatResult handleApplication(@RequestBody Map<String, Object> map) {
        testService.handleApplication(map);
        return FormatResult.ok();
    }

    @RequestMapping("getAppByIdentity")
    public FormatResult getAppByIdentity(@RequestBody Map<String, Object> map) {
        return FormatResult.ok(testService.getAppByIdentity(map));
    }


    @RequestMapping("buyOneGood")
    public FormatResult BuyGood() {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService executorService = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
//                synchronized (this) {
                lock.lock();
                int count = testService.getGoodCount(1);
                if (count > 0) {
                    testService.buyGood(1);
                }
//                }
                lock.unlock();
            });
        }
        return null;
    }

    @RequestMapping("getGoodCount")
    public Integer getGoodCount() {
        return Good.GoodCount;
    }

    @RequestMapping("getAgeAnalysis")
    public FormatResult getAgeAnalysis() {
        return FormatResult.ok(testService.getAgeAnalysis());
    }
}
