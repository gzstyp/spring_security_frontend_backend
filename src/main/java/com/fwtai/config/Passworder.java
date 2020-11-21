package com.fwtai.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码校验器
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020/6/6 12:43
 * @QQ号码 444141300
 * @Email service@yinlz.com
 * @官网 <url>http://www.yinlz.com</url>
*/
@Component
public class Passworder extends BCryptPasswordEncoder{

    //生成密码
    @Override
    public String encode(final CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    //验证匹配密码
    @Override
    public boolean matches(final CharSequence rawPassword,final String encodedPassword) {
        return super.matches(rawPassword,encodedPassword);
    }
}