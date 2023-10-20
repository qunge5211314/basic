package com.canal.basic.mapper;

import com.canal.basic.model.SysUser;
import com.canal.basic.vo.request.AddUserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    SysUser findByIdentity(AddUserVO addUserVO);

    void addSysUser(SysUser sysUser);
}
