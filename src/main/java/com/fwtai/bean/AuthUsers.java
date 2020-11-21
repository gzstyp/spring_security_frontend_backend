package com.fwtai.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    private String password;

    public AuthUsers(){}

    public AuthUsers(final String username,final boolean enabled,final List<String> authorities,final boolean accountNonLocked){
        this.username = username;
        this.enabled = enabled;
        this.authorities = authorities;
        this.accountNonLocked = accountNonLocked;
    }

    public AuthUsers(final String username,final String password,final boolean enabled,final List<String> authorities,final boolean accountNonLocked){
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    public void setUsername(final String username){
        this.username = username;
    }

    public void setPassword(final String password){
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired(){
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked(){
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled(){
        return enabled;
    }

    public void setAccountNonExpired(final boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(final boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }

    public void setAuthorities(final List<String> authorities){
        this.authorities = authorities;
    }

    public void setCredentialsNonExpired(final boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(final boolean enabled){
        this.enabled = enabled;
    }
}