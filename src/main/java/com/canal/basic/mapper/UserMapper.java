package com.canal.basic.mapper;

import com.canal.basic.model.SysUser;
import com.canal.basic.vo.request.AddUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<SysUser> findByIdentity(String identity);

    void addSysUser(SysUser sysUser);


    List<SysUser> getAllUsers();

    void logicalDeleteUser(@Param("userIdList") List<Long> userIdList);
}
