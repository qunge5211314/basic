package com.canal.basic.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.canal.basic.model.User;
import com.canal.basic.response.ApiResponse;
import com.canal.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.InvocableHandlerMethod;

import java.util.List;
import java.util.Map;


@Controller
@ResponseBody
@RequestMapping(value = "/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${basic.response.message.success}")
    private String successMessage;

}
