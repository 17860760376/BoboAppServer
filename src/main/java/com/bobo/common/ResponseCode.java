package com.bobo.common;

public enum ResponseCode {
    USERNAME_NOT_EMPTY(1,"用户名不能为空"),
    PASSWORD_NOT_EMPTY(2,"密码不能为空"),
    USERNAME_NOT_EXISTS(3,"用户名不存在"),
    PASSWORD_ERROR(4,"密码错误"),
    USERANME_EXISTS(5,"用户已存在"),
    PHONECODE_NOT_EMPTY(6,"验证码不能为空"),
    PHONECODE_ERROR(7,"验证码错误"),
    REGISTER_FAIL(8,"注册失败"),
    REGITTER_INIT_FAIL(9,"用户信息初始化失败"),
    ;
    private int code;
        private String msg;
        ResponseCode(int code,String msg){
            this.code=code;
            this.msg=msg;
        }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
