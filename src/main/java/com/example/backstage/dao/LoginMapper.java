package com.example.backstage.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoginMapper {

    Map<String,String> getMenuOne(Map<String,String> map);

    List<Map<String,Object>> getMenu(Map<String,String> map);
}
