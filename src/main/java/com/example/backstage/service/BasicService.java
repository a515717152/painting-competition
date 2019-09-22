package com.example.backstage.service;

import com.example.backstage.pojo.Menu;

import java.util.List;
import java.util.Map;

public interface BasicService {

    List<Map<String,Object>> getMenuList(Map<String,Object> map);

    String getSort(Map<String,Object> map);

    int addMenu(Menu menu);

    int updateMenu(Menu menu);

    int deleteMenu(Menu menu);
}
