package com.canal.basic.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class SysRole extends BaseTreeModel implements Serializable {
    private String roleName;
}
