package com.example.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.example.backstage.common.Result;
import com.example.backstage.pojo.User;
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
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        System.out.println(Sid.nextShort());
    }


    // 注册用户
    /*
    * 思路: 1.注册时,先验证手机号码是否已注册.
    *       2. 创建用户前,先创建用户填写的学校.
    *       3.  学校创建完毕后,插入用户数据
    * */
    @RequestMapping(value = "registry")
    public String registry(User user) {
        // 拿上手机号码判断是否注册
        Map<String, Object> search = new HashMap<String, Object>();
        Map<String, Object> add = new HashMap<>();
        add.put("id", Sid.nextShort());
        add.put("nick_name", "早期教育"+Sid.nextShort());// 默认随机姓名
        add.put("user_name", user.getUser_name());
        add.put("pass_word", user.getPass_word());
        add.put("delete_flag", PublicAttribute.UN_DELETE);
        add.put("stage", PublicAttribute.NOT_DISABLED);
        int result = userService.addUser(add);
        if (result > 0) return JSON.toJSONString(Result.ok());
        return JSON.toJSONString(Result.error());
    }



}
