package com.example.backstage.common;

public interface StatusCode {

    //成功
    public static final int OK = 0;

    //失败
    public static final int ERROR = 1;

    //用户名或密码错误
    public static final int LOGINERROR = 20002;

    //权限不足
    public static final int ACCESSERROR = 20003;

    //远程调用失败
    public static final int REMOTEERROR = 20004;

    //重复操作
    public static final int REPERROR = 20005;

}


