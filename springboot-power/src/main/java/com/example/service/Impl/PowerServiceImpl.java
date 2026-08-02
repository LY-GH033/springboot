package com.example.service.Impl;

import com.example.mapper.PowerMapper;
import com.example.pojo.Power;
import com.example.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public Power findByPowerName(String powerName) {
        Power power = powerMapper.findByPowerName(powerName);
        return power;
    }

    @Override
    public List<Power> findAll() {
        return powerMapper.findAll();
    }

    @Override
    public void add(String powerName, String responsiblePerson, String manufacturer, String location, String specModel, String basicInfo, String remark) {
        powerMapper.add(powerName,responsiblePerson,manufacturer,location,specModel,basicInfo,remark);
    }

    @Override
    public void update(String powerName, String responsiblePerson, String manufacturer, String location, String specModel, String basicInfo, String remark) {
        powerMapper.update(powerName,responsiblePerson,manufacturer,location,specModel,basicInfo,remark);
    }

    @Override
    public void delete(String powerName) {
        powerMapper.delete(powerName);
    }
}
