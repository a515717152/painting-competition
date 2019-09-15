package com.example.backstage.service;

import java.util.List;
import java.util.Map;

public interface LoginService {

    Map<String,String> getMenuOne(Map<String,String> map);

    List<Map<String,Object>> getMenu(Map<String,String> map);
}
