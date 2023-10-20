package com.canal.basic.converter;

import com.canal.basic.model.SysUser;
import com.canal.basic.vo.request.AddUserVO;
import lombok.experimental.SuperBuilder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserConverter {

    SysUser addUserVOToUserModel(AddUserVO addUserVO);
}
