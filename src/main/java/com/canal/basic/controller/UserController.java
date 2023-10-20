package com.canal.basic.controller;

import com.canal.basic.response.ApiResponse;
import com.canal.basic.service.UserService;
import com.canal.basic.vo.request.AddUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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

}
