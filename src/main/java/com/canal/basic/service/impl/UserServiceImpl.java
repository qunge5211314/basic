package com.canal.basic.service.impl;

import com.canal.basic.converter.UserConverter;
import com.canal.basic.exception.DataConflictException;
import com.canal.basic.mapper.UserMapper;
import com.canal.basic.model.SysUser;
import com.canal.basic.service.UserService;
import com.canal.basic.util.MD5Util;
import com.canal.basic.vo.request.AddUserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserConverter userConverter;

    @Resource
    private MD5Util md5Util;

    @Value("${basic.user.default.pwd}")
    private String defaultPwd;

    public void addSysUser(AddUserVO addUserVO) {
        // 判断是否有重复ID的用户
        List<SysUser> byIdentity = userMapper.findByIdentity(addUserVO.getIdentity());
        if (!byIdentity.isEmpty()) {
            throw new DataConflictException("ID已存在");
        }
        SysUser sysUser = userConverter.addUserVOToUserModel(addUserVO);
        sysUser.setPwd(md5Util.encrypt(defaultPwd));
        sysUser.setIs_sys(false);
        userMapper.addSysUser(sysUser);
    }
}
