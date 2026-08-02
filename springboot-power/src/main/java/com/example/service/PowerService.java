package com.example.service;

import com.example.pojo.Power;

import java.util.List;

public interface PowerService {

    Power findByPowerName(String powerName);

    List<Power> findAll();

    void add(String powerName,String responsiblePerson,String manufacturer,String location,String specModel,String basicInfo,String remark);

    void update(String powerName,String responsiblePerson,String manufacturer,String location,String specModel,String basicInfo,String remark);

    void delete(String powerName);

}
