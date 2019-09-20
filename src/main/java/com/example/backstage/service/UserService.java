package com.example.backstage.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {

    List<Map<String,Object>> getUserList(Map<String,String> map);

    Set<String> getRole(Map<String,String> map);

    Set<String> getPermission(Map<String,String> map);

    int addUser(Map<String,Object> map);

}
