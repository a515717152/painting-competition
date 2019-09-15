package com.example.backstage.service.impl;

import com.example.backstage.dao.LoginMapper;
import com.example.backstage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map<String, String> getMenuOne(Map<String, String> map) {
        return loginMapper.getMenuOne(map);
    }

    @Override
    public List<Map<String, Object>> getMenu(Map<String, String> map) {
        return loginMapper.getMenu(map);
    }
}
