package com.jstu.serve.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    List<Map<String,Object>> testSelect();

    Map<String,Object> login(Map<String,Object> map);

    Integer updateUser(Map<String,Object> map);

    List<Map<String,Object>> getEmployeeAll();

    List<String> getStoreAll();

    List<Map<String, Object>> getSupplier();

    List<Map<String,Object>> getRecord();

    Integer updateRecord(Map<String,Object> map);

    List<Map<String,Object>> getStore();

    Integer getKindCount();

    Integer getKind1();
    Integer getKind2();
    Integer getKind3();
    Integer getKind4();
    Integer getKind5();

    List<Map<String,Object>> getStoreAddress();
    Integer addStore(Map<String,Object> map);
    Integer addEmployee(Map<String,Object> map);
    Integer addSupplier(Map<String,Object> map);

    Integer addPeopleCount(Map<String,Object> map);


    Integer addApplication(Map<String,Object> map);

    List<Map<String,Object>> getApplication();

    Integer updateAppStatus(Map<String,Object> map);

    Integer updateEmployee1();

    Integer updateEmployee2(Map<String,Object> map);

    Map<String,Object> getAppByIdentity(Map<String,Object> map);

    Integer getGoodCount(int good_id);
    Integer buyGood(int good_id);


    Map<String,Object> getAgeAnalysis();
 }
