package com.example.backstage.util;

public class PublicAttribute {

    // 可选角色:
    public static String ORDINARY_ADMINISTRATOR_ROLE_ID = "2019";// 默认初始注册为普通角色ID
    public static String ADMINISTRATOR_ROLE = "admin";// 管理员角色
    public static String PRIMARY_ADMINISTRATOR_ROLE = "primary";// 一等角色
    public static String ORDINARY_ADMINISTRATOR_ROLE = "ordinary";// 普通角色

    // 可选权限
    public static String ADMINISTRATOR_RIGHTS = "admin:all";// 最高权限
    public static String PRIMARY_ADMINISTRATOR_RIGHTS = "admin:primary";// 一等权限
    public static String ORDINARY_ADMINISTRATOR_RIGHTS = "admin:ordinary";// 普通权限

    // 0未删除、1已删除
    public static String UN_DELETE = "0";
    public static String DELETED= "1";
    // 0已禁用、1正在使用
    public static String DISABLED = "0";
    public static String NOT_DISABLED = "1";

}
