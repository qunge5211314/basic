package com.canal.basic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser extends BaseModel implements Serializable {

    private String username;

    private String identity;

    private String email;

    private String pwd;

    private Boolean gender;

    private Boolean state;

    private Boolean is_sys = false;
}
