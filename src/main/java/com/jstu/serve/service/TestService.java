package com.jstu.serve.service;

import java.util.List;
import java.util.Map;

/**
 * @author 呆居
 */
public interface TestService {

    List<Map<String, Object>> testSelect();

    Map<String, Object> login(Map<String, Object> map);

    Integer updateUser(Map<String, Object> map);

    List<Map<String, Object>> getEmployeeAll();

    List<String> getStoreAll();

    List<Map<String, Object>> getSupplier();

    List<Map<String, Object>> getRecord();


    Integer updateRecord(Map<String, Object> map);

    List<Map<String, Object>> getStore();

    List<Map<String, Object>> getKindCount();

    List<Map<String, Object>> getStoreAddress();

    Integer addStore(Map<String, Object> map);

    Integer addEmployee(Map<String, Object> map);

    Integer addSupplier(Map<String, Object> map);

    Integer addApplication(Map<String,Object> map);

    List<Map<String,Object>> getApplication();

    void handleApplication(Map<String,Object> map);

    Map<String,Object> getAppByIdentity(Map<String,Object> map);

    Integer getGoodCount(int good_id);
    Integer buyGood(int good_id);

    List<Map<String,Object>> getAgeAnalysis();
}
