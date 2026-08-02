package com.example.controller;

import com.example.pojo.Power;
import com.example.pojo.Result;
import com.example.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    @PostMapping("add")
    public Result addPower(String powerName, String responsiblePerson, String manufacturer, String location, String specModel, String basicInfo, String remark){
        Power power = powerService.findByPowerName(powerName);
        if (power == null){
            powerService.add(powerName,responsiblePerson,manufacturer,location,specModel,basicInfo,remark);
            return Result.success();
        }else {
            return Result.error("电源名已存在");
        }
    }

    @GetMapping("/{powerName}")
    public Result getByPowerName(@PathVariable String powerName){
        Power power = powerService.findByPowerName(powerName);
        return Result.success(power);
    }

    @GetMapping("getAll")
    public List<Power> getAll(){
        return powerService.findAll();
    }

    @PutMapping("/update")
    public Result update(String powerName, String responsiblePerson, String manufacturer, String location, String specModel, String basicInfo, String remark) {
        powerService.update(powerName,responsiblePerson,manufacturer,location,specModel,basicInfo,remark);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(String powerName){
        powerService.delete(powerName);
        return Result.success();
    }

}
