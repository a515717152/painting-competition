package com.example.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.example.backstage.common.Result;
import com.example.backstage.pojo.Menu;
import com.example.backstage.pojo.User;
import com.example.backstage.service.BasicService;
import com.example.backstage.service.UserService;
import com.example.backstage.util.PublicAttribute;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 基础设置: 角色,菜单管理
* */
@RestController
@RequestMapping(value = "/basic/")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @Autowired
    private UserService userService;

    // 后台用户管理 - 查询
    @RequestMapping(value = "userList")
    public String getUserList(String nick_name,String user_name) {
        Map<String, String> search = new HashMap<>();
        search.put("nick_name",nick_name);
        search.put("user_name",user_name);
        search.put("delete_flag",PublicAttribute.UN_DELETE);
        search.put("stage",PublicAttribute.NOT_DISABLED);
        List<Map<String, Object>> userList = userService.getUserList(search);
        String s = JSON.toJSONString(Result.ok(userList, (long) userList.size()));
        System.out.println(s);
        return s;
    }

    // 后台用户管理 - 新增
    @RequestMapping(value = "addUser")
    public String addUser(User user) {
//        List<Map<String, Object>> userList = userService.getUserList(search);
        return JSON.toJSONString(Result.ok());
    }



    // 后台菜单管理 - 展示数据
    @RequiresRoles("root")
    @RequestMapping("menuList")
    public String getMenuList(){
        // 查询
        HashMap<String, Object> search = new HashMap<>();
        search.put("delete_flag", PublicAttribute.UN_DELETE);
        search.put("stage", PublicAttribute.NOT_DISABLED);
        List<Map<String, Object>> menuList = basicService.getMenuList(search);
        search.clear();
        search.put("code",0);
        search.put("msg","");
        search.put("count",menuList.size());
        search.put("data",menuList);
        return JSON.toJSONString(Result.ok(menuList,(long)menuList.size()));
    };

    // 后台菜单管理 - 新增
    @RequiresRoles("root")
    @RequestMapping("addMenu")
    public String addMenu(Menu menu){
        // 查询,当前排序位数
        HashMap<String, Object> search = new HashMap<>();
        search.put("delete_flag", PublicAttribute.UN_DELETE);
        search.put("stage", PublicAttribute.NOT_DISABLED);
        String sort = basicService.getSort(search);
        sort = Integer.parseInt(sort)+1+"";

        // 新增
        menu.setSort(sort);
        menu.setDelete_flag(PublicAttribute.UN_DELETE);
        menu.setStage(PublicAttribute.NOT_DISABLED);
        basicService.addMenu(menu);
        return JSON.toJSONString(Result.ok());
    };

    // 后台菜单管理 - 修改
    @RequiresRoles("root")
    @RequestMapping("updateMenu")
    public String updateMenu(Menu menu){
        int i = basicService.updateMenu(menu);
        return JSON.toJSONString(Result.ok());
    };

    // 后台菜单管理 - 删除(物理删除)
    @RequiresRoles("root")
    @RequestMapping("deleteMenu")
    public String deleteMenu(Menu menu){
        // 判断: 删除目录 - 则删除目录以下所有菜单
        if(StringUtils.isEmpty(menu.getHref())){

        }
        int i = basicService.updateMenu(menu);
        return JSON.toJSONString(Result.ok());
    };



}
