package com.canal.basic.response;

public enum ResponseCode {
    SUCCESS(200L, "成功"),
    PARAM_ERROR(400L, "参数错误"),
    UNAUTHORIZED(401L, "认证失效，需要重新登陆认证"),
    FORBIDDEN(403L, "权限不足"),
    NOT_FOUND(404L, "路径未找到"),
    METHOD_ERROR(405L, "请求方法错误"),
    CONFLICT(409L, "数据冲突(新增或更新后出现本不应出现的重复数据)"),
    GONE(450L, "数据在服务器上不存在或已失效"),
    SERVER_ERROR(500L, "服务器内部异常");

    private Long code;
    private String comment;

    ResponseCode() {
    }

    ResponseCode(Long code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
