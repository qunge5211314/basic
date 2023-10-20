package com.canal.basic.enumeration;

import lombok.*;

@AllArgsConstructor
@Getter
public enum SysUserState {
    ENABLE(true, "启用"),
    DISABLE(false, "禁用");
    private final Boolean code;
    private final String comment;


}
