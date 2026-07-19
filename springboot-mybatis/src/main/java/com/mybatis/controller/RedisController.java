package com.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *
     * @param key redisKey
     * @param value redisValue
     * @param min redisMin，存储值过期时间，数字（默认分钟）
     * @return
     */
    @GetMapping("/set")
    public String setRedis(@RequestParam("key") String key,
                           @RequestParam("value") String value,
                           @RequestParam("min") Integer min){

        stringRedisTemplate.opsForValue().set(key,value,min, TimeUnit.MINUTES);
        return "设置成功，请访问 <a href='/redis/get?key=\" + key + \"'>此处</a> 进行测试";

    }

    /**
     * 查询值
     * @param key 查询key
     * @return
     */
    @GetMapping("/get")
    public String getRedis(@RequestParam("key") String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

}
