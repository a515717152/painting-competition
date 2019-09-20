package com.example.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.example.backstage.service.UserService;
import com.example.backstage.util.PublicAttribute;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: backstage
 * @description: 用户管理
 * @author: liuyan
 * @create: 2019-09-20 15:02
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 注册用户
    @RequestMapping(value = "registry")
    public String registry(String nickname,String userName, String password) {
        Map<String, Object> add = new HashMap<>();
        add.put("id", Sid.nextShort());
        add.put("nickname", userName);// 默认随机姓名
        add.put("username", userName);
        add.put("password", password);
        add.put("role_id", PublicAttribute.ORDINARY_ADMINISTRATOR_ROLE_ID);
        add.put("delete_flag", PublicAttribute.UN_DELETE);
        add.put("stage", PublicAttribute.NOT_DISABLED);
        int result = userService.addUser(add);
        if (result > 0) return "success";
        return "false";
    }

    // 查询用户
    @RequestMapping(value = "getUserList")
    public String getUserList(HttpServletRequest request) {
        Map<String, String> search = new HashMap<>();
        List<Map<String, Object>> userList = userService.getUserList(search);
        return JSON.toJSONString(userList);
    }

}
