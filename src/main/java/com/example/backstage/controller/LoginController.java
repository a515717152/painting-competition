package com.example.backstage.controller;

import com.alibaba.fastjson.JSON;
import com.example.backstage.service.LoginService;
import com.example.backstage.util.ErgodicUtil;
import com.example.backstage.util.PublicAttribute;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 登录校验
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("-------- 登录认证开始 -------");
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {//认证成功跳转至后台首页
            return "1";
        } else {
            token.clear();
            return "网络错误";
        }
    }

    //  退出登录 - 其实就是kill掉服务器里面的用户session
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    @ResponseBody
    public String loginOut(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "";
    }

    // 左侧菜单及其他数据
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
    public String menu() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, String> search = new HashMap<>();
        search.put("delete_flag", PublicAttribute.UN_DELETE);
        search.put("stage", PublicAttribute.NOT_DISABLED);

        // 默认打开后台展示页面
        search.put("menu_type", "homeInfo");
        Map<String, String> homeInfo = loginService.getMenuOne(search);

        // 打开后台首页后左上角图标
        search.put("menu_type", "logoInfo");
        Map<String, String> logoInfo = loginService.getMenuOne(search);

        // 打开首页后的左侧展示菜单 - 递归查询
        Map<String, Object> currency1 = new HashMap<String, Object>();
        Map<String, Object> currency2 = new HashMap<String, Object>();
        search.put("menu_type", "menuInfo");
        //先查询所有菜单
        List<Map<String, Object>> list = loginService.getMenu(search);

        // 进行递归
        //准备容器
        List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
        // 先获取顶级菜单数据
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> stringObjectMap = list.get(i);
            if (ObjectUtils.isEmpty(stringObjectMap.get("href"))) {
                menuList.add(stringObjectMap);
                list.remove(i);
                i--;
            }
        }
        // 遍历顶级菜单.调用递归方法.
        for (int j = 0; j < menuList.size(); j++) {
            Map<String, Object> pMap = menuList.get(j);
            pMap.put("child", ErgodicUtil.getChild(pMap.get("id").toString(), list));
            //调用递归方法: getChild(顶级菜单id, 所有菜单内容).得到该菜单下的子菜单.
        }

        currency1.put("title", "常规管理");
        currency1.put("icon", "fa fa-address-book");
        currency1.put("child", menuList);
        currency2.put("currency", currency1);
        // 存储到需要返回的对象中
        result.put("homeInfo", homeInfo);
        result.put("logoInfo", logoInfo);
        result.put("menuInfo", currency2);
        String s = JSON.toJSONString(result);
        System.out.println(s);
        return s;
    }


    // 菜单管理




}
