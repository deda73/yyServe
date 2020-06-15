package com.jstu.serve.controller;


import com.jstu.serve.service.TestService;
import com.jstu.serve.util.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return FormatResult.ok(testService.getSupplier());
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
    public FormatResult addApplication(@RequestBody Map<String,Object> map) {
        testService.addApplication(map);
        return FormatResult.ok();

    }

    @RequestMapping("getApplication")
    public FormatResult getApplication() {
        return FormatResult.ok(testService.getApplication());
    }

    @RequestMapping("handleApplication")
    public FormatResult handleApplication(@RequestBody Map<String,Object> map){
        testService.handleApplication(map);
        return FormatResult.ok();
    }

    @RequestMapping("getAppByIdentity")
    public FormatResult getAppByIdentity(@RequestBody Map<String,Object> map) {
        return FormatResult.ok(testService.getAppByIdentity(map));
    }
}
