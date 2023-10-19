package com.canal.basic.enumeration;

public enum UserOperation {
    REGISTER(0L, "注册"),
    UPDATE_PASSWORD(1L, "更改密码");
    private Long code;
    private String name;

    UserOperation() {
    }

    UserOperation(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
