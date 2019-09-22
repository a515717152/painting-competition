package com.example.backstage.common;

public class Result {

    private boolean flag;
    private Integer code;
    private String msg;
    private Object data;
    private Long count;

    private Result() {
    }

    private Result(boolean flag, Integer code, String msg) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
    }

    private Result(boolean flag, Integer code, String msg, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(boolean flag, Integer code, String msg, Object data, Long count) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result ok() {
        return new Result(true, StatusCode.OK, "成功");
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result ok(Object data) {
        return new Result(true, StatusCode.OK, "成功", data);
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result ok(String msg, Object data) {
        return new Result(true, StatusCode.OK, "成功", data);
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result ok(Object data, Long count) {
        return new Result(true, StatusCode.OK, "成功", data, count);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static Result error() {
        return new Result(false, StatusCode.ERROR, "error");
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static Result error(String msg) {
        return new Result(false, StatusCode.ERROR, msg);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static Result error(Integer code, String msg) {
        return new Result(false, code, msg);
    }

    /**
     * 返回登录失败的消息：用户名或密码错误
     * @return Result
     */
    public static Result loginError() {
        return new Result(false, StatusCode.LOGINERROR, "用户名或密码错误");
    }

    /**
     * 返回权限不足
     * @return Result
     */
    public static Result accessError() {
        return new Result(false, StatusCode.ACCESSERROR, "权限不足");
    }

    /**
     * 返回远程调用失败
     * @return Result
     */
    public static Result remoteError() {
        return new Result(false, StatusCode.REMOTEERROR, "远程调用失败");
    }

    /**
     * 返回重复操作
     * @return Result
     */
    public static Result repError() {
        return new Result(false, StatusCode.REPERROR, "重复操作");
    }
}

