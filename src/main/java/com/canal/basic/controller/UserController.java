package com.canal.basic.controller;

import com.canal.basic.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("用户管理")
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @GetMapping("/a")
    @ApiOperation(value = "测试接口", notes = "测试接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApiResponse<String> test(){
        String a = "hello word";
        return ApiResponse.success(a);
    }

}
