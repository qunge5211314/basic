package com.canal.basic.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum yesOrNot {
    YES(true, "是"),
    NOT(false, "否");
    private Boolean yes;
    private String comment;
}
