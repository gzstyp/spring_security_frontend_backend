package com.fwtai.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 自定义认证
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-11-21 13:42
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Component
public class UserAuthService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException{
        return null;
    }
}