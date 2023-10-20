package com.canal.basic.vo.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加用户数据")
public class AddUserVO {
    @ApiModelProperty(value = "姓名", required = true)
    private String username;
    @ApiModelProperty(value = "ID", required = true)
    private String identity;
    @ApiModelProperty(value = "邮箱", required = true)
    private String email;
    @ApiModelProperty(value = "性别", required = true)
    private Boolean gender;
    @ApiModelProperty(value = "状态", required = true)
    private Boolean state;
}
