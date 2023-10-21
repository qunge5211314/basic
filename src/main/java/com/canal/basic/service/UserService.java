package com.canal.basic.service;

import com.canal.basic.model.SysUser;
import com.canal.basic.vo.request.AddUserVO;

import java.util.List;

public interface UserService {
    void addSysUser(AddUserVO addUserVO);

    List<SysUser> getAllUsers();


    void logicalDeleteUser(List<Long> userIdList);
}
