package com.fwtai.bean;

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
public final class AuthUsers{

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private List<String> authorities;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String username;

    public boolean isAccountNonExpired(){
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked(){
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }

    public List<String> getAuthorities(){
        return authorities;
    }

    public void setAuthorities(List<String> authorities){
        this.authorities = authorities;
    }

    public boolean isCredentialsNonExpired(){
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}