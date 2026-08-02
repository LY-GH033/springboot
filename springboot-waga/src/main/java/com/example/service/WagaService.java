package com.example.service;

import com.example.pojo.Waga;

import java.util.List;

public interface WagaService {

    Waga getByWagaCode(String wagaCode);

    List<Waga> getAll();

    int insert(Waga waga);

    int update(Waga waga);

    int deleteByWagaCode(String wagaCode);

}
