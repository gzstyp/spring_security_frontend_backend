package com.fwtai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-11-20 23:59
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
public class HelloController{

    @GetMapping("/")
    public String index(){
        return "欢迎访问";
    }

    @GetMapping("/hello")
    public String hello(){
        return "www.dwz.cloud";
    }

    @PostMapping("/succeed")
    public String succeed(){
        return "登录成功";
    }

    @GetMapping("/success")
    public String success(){
        return "登录成功";
    }

    @GetMapping("/failure")
    public String failure(){
        return "账号或密码错误,是重定向,是客户端跳转";
    }

    @PostMapping("/fail")
    public String fail(){
        return "账号或密码错误,它是服务端跳转,URL路径不变,因为登录的url就是/loginAuth";
    }
}