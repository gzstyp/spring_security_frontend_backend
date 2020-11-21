package com.fwtai.controller;

import com.fwtai.tool.ToolClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-11-21 12:41
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
public class ApiController{

    @Resource
    private ToolClient client;

    // http://127.0.0.1:88/api/hello
    @GetMapping("/api/hello")
    public void hello(final HttpServletRequest request,final HttpServletResponse response){
        final String json = client.json(200,"需要登录认证才可以访问,无需任何角色");
        client.responseJson(json,response);
    }

    // http://127.0.0.1:88/admin/hello
    @GetMapping("/admin/hello")
    public void admin(final HttpServletRequest request,final HttpServletResponse response){
        final String json = client.json(200,"拥有admin角色");
        client.responseJson(json,response);
    }

    // http://127.0.0.1:88/admin/hello
    @GetMapping("/user/hello")
    public void user(final HttpServletRequest request,final HttpServletResponse response){
        final String json = client.json(200,"拥有user角色");
        client.responseJson(json,response);
    }
}