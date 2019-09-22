package com.example.backstage.service.impl;

import com.example.backstage.dao.BasicMapper;
import com.example.backstage.pojo.Menu;
import com.example.backstage.service.BasicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasicServiceImpl implements BasicService {

    @Resource
    private BasicMapper basicMapper;

    @Override
    public List<Map<String,Object>> getMenuList(Map<String,Object> map) {
        return basicMapper.getMenuList(map);
    }

    @Override
    public String getSort(Map<String,Object> map) {
        return basicMapper.getSort(map);
    }

    @Override
    public int addMenu(Menu menu) {
        return basicMapper.addMenu(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return basicMapper.updateMenu(menu);
    }

    @Override
    public int deleteMenu(Menu menu) {
        return basicMapper.deleteMenu(menu);
    }
}
