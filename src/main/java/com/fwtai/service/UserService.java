package com.fwtai.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-11-21 17:37
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Service
public class UserService{

    public String login(final String userName){
        if(userName.equals("admin")){
            return "102485156";
        }
        return null;
    }

    public List<String> getRole(final String userId){
        final List<String> roles = new ArrayList<String>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }
}