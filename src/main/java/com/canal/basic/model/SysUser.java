package com.canal.basic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class SysUser extends BaseModel implements Serializable {

    private String userName;

    private String identity;

    private String email;

    private String pwd;

    private Boolean gender;

    private Boolean state;

    private Boolean isSys;
}
