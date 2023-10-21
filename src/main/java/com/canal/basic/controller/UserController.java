package com.canal.basic.controller;

import com.canal.basic.model.SysUser;
import com.canal.basic.response.ApiResponse;
import com.canal.basic.service.UserService;
import com.canal.basic.vo.request.AddUserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@RestController
@Api(tags = "用户管理")
@RequestMapping(value = "/user")
public class UserController {
    @Value("${basic.response.message.success}")
    private String successMessage;

    @Resource
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation(value = "添加用户接口", notes = "添加用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApiResponse<String> addUser(@RequestBody AddUserVO addUserVO) {
        userService.addSysUser(addUserVO);
        return ApiResponse.success(successMessage);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户接口", notes = "删除用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApiResponse<String> deleteUser(@RequestParam List<Long> userIdList) {
        userService.logicalDeleteUser(userIdList);
        return ApiResponse.success(successMessage);
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表接口", notes = "查询用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApiResponse<PageInfo<SysUser>> userList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true, false, null);
        List<SysUser> users = userService.getAllUsers();
        return ApiResponse.success(successMessage, new PageInfo<>(users));
    }
}
