package com.canal.basic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@SuperBuilder
public class User extends BaseModel implements Serializable {

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private Boolean gender;

    private String portrait;
}
