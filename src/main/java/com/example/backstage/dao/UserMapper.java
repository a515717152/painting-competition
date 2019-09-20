package com.example.backstage.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: backstage
 * @description:
 * @author: liuyan
 * @create: 2019-09-20 15:06
 **/
public interface UserMapper {

    List<Map<String,Object>> getUserList(Map<String,String> map);

    Set<String> getRole(Map<String,String> map);

    Set<String> getPermission(Map<String,String> map);

    int addUser(Map<String,Object> map);
}
