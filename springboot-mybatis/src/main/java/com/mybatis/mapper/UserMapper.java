package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 根据 id 查询用户
    User getById(int id);
    // 根据用户名查询用户
    List<User> getByUsername(String username);

    /**
     * 查询用户列表
     * @return
     */
    List<User> getAll();
    // 新增用户
    int insert(User user);
    // 更新用户信息
    int update(User user);
    // 根据 id 删除用户
    int deleteById(int id);
}
