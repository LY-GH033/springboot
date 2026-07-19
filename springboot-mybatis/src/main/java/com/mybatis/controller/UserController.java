package com.mybatis.controller;

import com.mybatis.pojo.User;
import com.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/add")
    public Map<String, Object> addUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("2415test1");
        user.setPassword("123456");
        user.setEmail("2415test1@qq.com");
        int rows = userService.insert(user);

        Map<String, Object> res = new HashMap<>();
        res.put("status", rows > 0 ? "success" : "fail");
        res.put("data", "已尝试新增固定用户");
        return res;
    }

    /**
     *  查询单个用户 (GET)
     *  http://localhost:8080/user/16
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User query(@PathVariable Integer id) {
        return userService.getById(id);
    }


    /**
     * 查询所有用户
     * @return
     * http://localhost:8080/user/getAll
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * 修改用户 (GET 模拟 PUT)
     浏览器访问: http://localhost:8080/user/update
     */
    @GetMapping("/update")
    public Map<String, Object> update(int id) {
        // 方法内固定修改 ID 为 16 的用户信息

        User user = new User();
        user.setId(id);
        user.setUsername("2415test1");
        user.setPassword("123456");
        user.setEmail("2415test1@qq.com-update-20260514");
        int rows = userService.update(user);

        Map<String, Object> res = new HashMap<>();
        res.put("status", rows > 0 ? "success" : "fail");
        res.put("msg", "已尝试修改 ID 为 "+id+" 的数据为固定值");
        return res;
    }

    /**
     * 删除用户 (GET 模拟 DELETE)
     http://localhost:8080/user/delete/1
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        int rows = userService.deleteById(id);
        return rows > 0 ? "ID为 " + id + " 的用户删除成功" : "删除失败";
    }

    // 根据用户名查询用户
    @RequestMapping(method = RequestMethod.GET, value="/getByUsername")
    public List<User> getByUsername(String username) {
        return userService.getByUsername(username);
    }


}
