package com.example.mapper;

import com.example.pojo.Power;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PowerMapper {

    @Select("select * from test_power where power_name=#{powerName}")
    Power findByPowerName(String powerName);

    @Select("select * from test_power")
    List<Power> findAll();

    @Insert("insert into test_power(power_name,responsible_person,manufacturer,location,spec_model,basic_info,remark)" +
            " values (#{powerName},#{responsiblePerson},#{manufacturer},#{location},#{specModel},#{basicInfo},#{remark})")
    void add(String powerName,String responsiblePerson,String manufacturer,String location,String specModel,String basicInfo,String remark);

    @Update("update test_power set responsible_person=#{responsiblePerson},manufacturer=#{manufacturer},location=#{location},spec_model=#{specModel},basic_info=#{basicInfo},remark=#{remark} where power_name=#{powerName}")
    void update(String powerName,String responsiblePerson,String manufacturer,String location,String specModel,String basicInfo,String remark);

    @Delete("delete from test_power where power_name=#{powerName}")
    void delete(String powerName);

}
