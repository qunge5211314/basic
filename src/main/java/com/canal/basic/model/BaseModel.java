package com.canal.basic.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Date;
import io.swagger.annotations.ApiModelProperty;

@Data
@SuperBuilder
public abstract class BaseModel implements Serializable {
    private Long id;

    private Boolean isValid = true;

    private Date createTime;

    private Date updateTime;
}
