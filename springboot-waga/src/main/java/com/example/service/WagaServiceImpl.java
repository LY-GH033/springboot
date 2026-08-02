package com.example.service;

import com.example.mapper.WagaMapper;
import com.example.pojo.Waga;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagaServiceImpl implements WagaService {

    @Resource
    private WagaMapper wagaMapper;

    @Override
    public Waga getByWagaCode(String wagaCode) {
        return wagaMapper.getByWagaCode(wagaCode);
    }

    @Override
    public List<Waga> getAll() {
        return wagaMapper.getAll();
    }

    @Override
    public int insert(Waga waga) {
        return wagaMapper.insert(waga);
    }

    @Override
    public int update(Waga waga) {
        return wagaMapper.update(waga);
    }

    @Override
    public int deleteByWagaCode(String wagaCode) {
        return wagaMapper.deleteByWagaCode(wagaCode);
    }


}
