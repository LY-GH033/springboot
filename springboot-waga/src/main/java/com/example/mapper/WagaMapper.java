package com.example.mapper;

import com.example.pojo.Waga;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WagaMapper {

    Waga getByWagaCode(String wagaCode);

    List<Waga> getAll();

    int insert(Waga waga);

    int update(Waga waga);

    int deleteByWagaCode(String wagaCode);

}
