package com.example.controller;

import com.example.pojo.Waga;
import com.example.service.WagaService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/waga")
public class WagaController {

    @Resource
    private WagaService wagaService;

    @RequestMapping("/add")
    public Map<String,Object> addWaga(){
        Waga waga= new Waga();
        waga.setWagaCode("1");
        waga.setUswl(new BigDecimal(1234.56));
        waga.setDswl(new BigDecimal(6543.21));
        waga.setTtfl(new BigDecimal(12345.67));
        waga.setNote("");
        waga.setUpdateDate(LocalDateTime.now());
        int rows = wagaService.insert(waga);

        Map<String, Object> res = new HashMap<>();
        res.put("status", rows > 0 ? "1" : "0");
        res.put("data", "添加数据");
        return res;
    }

    @GetMapping("/{wagacode}")
    public Waga query(@PathVariable String wagacode) {
        return wagaService.getByWagaCode(wagacode);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public List<Waga> getAll() {
        return wagaService.getAll();
    }

    @RequestMapping("/update")
    public Map<String,Object> update(String wagaCode){
        Waga waga= new Waga();
        waga.setWagaCode(wagaCode);
        waga.setUswl(new BigDecimal(6543.21));
        waga.setDswl(new BigDecimal(1234.56));
        waga.setTtfl(new BigDecimal(12345.67));
        waga.setNote("");
        waga.setUpdateDate(LocalDateTime.now());
        int rows = wagaService.update(waga);

        Map<String, Object> res = new HashMap<>();
        res.put("status", rows > 0 ? "1" : "0");
        res.put("data", "修改数据");
        return res;
    }

    @GetMapping("delete/{wagacode}")
    public String delete(@PathVariable String wagacode){
        int rows = wagaService.deleteByWagaCode(wagacode);
        return rows > 0 ?"1":"0";
    }

}
