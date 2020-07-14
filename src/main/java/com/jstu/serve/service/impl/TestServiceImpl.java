package com.jstu.serve.service.impl;

import com.jstu.serve.dao.mapper.TestMapper;
import com.jstu.serve.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 呆居
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Map<String, Object>> testSelect() {
        return testMapper.testSelect();
    }

    @Override
    public Map<String, Object> login(Map<String, Object> map) {
        return testMapper.login(map);
    }

    @Override
    public Integer updateUser(Map<String, Object> map) {
        return testMapper.updateUser(map);
    }

    @Override
    public List<Map<String, Object>> getEmployeeAll() {
        return testMapper.getEmployeeAll();
    }

    @Override
    public List<String> getStoreAll() {
        return testMapper.getStoreAll();
    }

    @Override
    public List<Map<String, Object>> getSupplier() {
        return testMapper.getSupplier();
    }

    @Override
    public List<Map<String, Object>> getRecord() {
        return testMapper.getRecord();
    }

    @Override
    public Integer updateRecord(Map<String, Object> map) {
        return testMapper.updateRecord(map);
    }

    @Override
    public List<Map<String, Object>> getStore() {
        return testMapper.getStore();
    }

    @Override
    public List<Map<String, Object>> getKindCount() {
        Integer count = testMapper.getKindCount();
        Integer count1 = testMapper.getKind1();
        Integer count2 = testMapper.getKind2();
        Integer count3 = testMapper.getKind3();
        Integer count4 = testMapper.getKind4();
        Integer count5 = testMapper.getKind5();
        int[] counts = {count1, count2, count3, count4, count5};
        String[] kinds = {"肉类", "蔬菜类", "海鲜类", "调料类", "水果类"};
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", kinds[i]);
            map.put("value", counts[i]);
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> getStoreAddress() {
        return testMapper.getStoreAddress();
    }

    @Override
    public Integer addStore(Map<String, Object> map) {
        return testMapper.addStore(map);
    }

    @Override
    public Integer addEmployee(Map<String, Object> map) {
        testMapper.addPeopleCount(map);
        return testMapper.addEmployee(map);
    }

    @Override
    public Integer addSupplier(Map<String, Object> map) {
        return testMapper.addSupplier(map);
    }

    @Override
    public Integer addApplication(Map<String, Object> map) {
        return testMapper.addApplication(map);
    }

    @Override
    public List<Map<String, Object>> getApplication() {
        return testMapper.getApplication();
    }

    @Override
    public void handleApplication(Map<String, Object> map) {
        if(map.get("app_state").equals("同意")){
            testMapper.updateAppStatus(map);
            testMapper.updateEmployee1();
            testMapper.updateEmployee2(map);
        }
        else {
            testMapper.updateAppStatus(map);
        }
    }

    @Override
    public Map<String, Object> getAppByIdentity(Map<String,Object> map) {
        return testMapper.getAppByIdentity(map);
    }


}
