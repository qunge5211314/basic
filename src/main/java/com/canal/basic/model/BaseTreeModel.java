package com.canal.basic.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class BaseTreeModel extends BaseModel implements Serializable {
    private Long parentId;
    private Long treeId;
    private Integer lft;
    private Integer rgt;
    private Integer depth;
}
