package com.fwtai.service;

import com.fwtai.bean.AuthUsers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException{
        final String userId = userService.login(username);
        if(userId == null){
            throw new UsernameNotFoundException("账号或密码错误哦");
        }
        final List<String> list = userService.getRole(userId);
        final AuthUsers authUsers = new AuthUsers();
        return authUsers;
    }
}