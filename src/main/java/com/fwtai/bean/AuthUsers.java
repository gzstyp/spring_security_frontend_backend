package com.fwtai.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 登录认证
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-11-21 11:24
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
public final class AuthUsers implements UserDetails{

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private List<String> authorities;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String username;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public boolean isAccountNonExpired(){
        return false;
    }

    @Override
    public boolean isAccountNonLocked(){
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return false;
    }

    @Override
    public boolean isEnabled(){
        return false;
    }
}