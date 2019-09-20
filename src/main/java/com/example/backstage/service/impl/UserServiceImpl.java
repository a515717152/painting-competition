package com.example.backstage.service.impl;

import com.example.backstage.dao.UserMapper;
import com.example.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: backstage
 * @description:
 * @author: liuyan
 * @create: 2019-09-20 15:06
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getUserList(Map<String, String> map) {
        return userMapper.getUserList(map);
    }

    @Override
    public Set<String> getRole(Map<String, String> map) {
        return userMapper.getRole(map);
    }

    @Override
    public Set<String> getPermission(Map<String, String> map) {
        return userMapper.getPermission(map);
    }

    @Override
    public int addUser(Map<String, Object> map) {
        return 0;
    }
}
