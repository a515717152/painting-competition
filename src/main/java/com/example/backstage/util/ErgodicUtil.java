package com.example.backstage.util;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErgodicUtil {

    // 根据目录/菜单id查询它下面的子菜单id


    // 后台左侧菜单递归
    public static List<Map<String, Object>> getChild(String id, List<Map<String, Object>> rootMenu) {
        // 准备接收子菜单
        List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();
        //遍历所有菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            Map<String, Object> cMenu = rootMenu.get(i);
            Object parent_id = cMenu.get("parent_id");
            if (ObjectUtils.isNotEmpty(parent_id) && id.equals(parent_id.toString())) {
                childList.add(cMenu);
            }
        }
        for (int j = 0; j < childList.size(); j++) {
            Map<String, Object> c2Menu = childList.get(j);
            c2Menu.put("child", getChild(c2Menu.get("id").toString(), rootMenu));
        }
        // 递归退出条件: 如果childList.size() == 0,则表明传递进来的菜单下没有子菜单.
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
