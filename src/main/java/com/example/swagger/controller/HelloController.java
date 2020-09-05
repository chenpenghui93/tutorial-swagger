package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenpenghui
 * @date 2020-9-5
 */
@RestController
@Api
public class HelloController {

    @ApiOperation(value = "这个是测试接口ApiOperation")
//    @ResponseBody
    @PostMapping("/hello")
    public String hello(@ApiParam(name = "name", value = "名字value", required = true) @RequestBody String name) {
        return "hello " + name;
    }
}
