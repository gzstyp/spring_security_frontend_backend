package com.fwtai.config;

import com.fwtai.tool.ToolClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Security配置信息
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-11-21 0:15
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Resource
    private ToolClient client;

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception{
        web.ignoring()//忽略
        .antMatchers("/css/**","/images/**");
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("root").password("123").roles("admin");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception{
        http.authorizeRequests()//开启认证
        .anyRequest()//任何请求
        .authenticated()//认证之后才能访问
        .and()//此时又回到上面第1行的 'authorizeRequests()'
        .formLogin()//表单登录
        .loginProcessingUrl("/loginAuth")//post请求:http://192.168.3.108:88/loginAuth
        .usernameParameter("userName")//请求时登录账号参数名,即表单的name
        .passwordParameter("passWord")//登录密码参数名
        .loginPage("/login.html")//指定登录页面的url[若没有额外的指定的话默认的登录接口就是它,只是页面的get请求,而登录接口是post请求]

        //成功的回调,request可以客户端跳转[重定向];response可以服务器端跳转,当然可以返回json;authentication包含登录成功的数据信息;此时不会跳转了,要跳转只需在客户端做处理即可;
        .successHandler((request,response,authentication)->{// 它是接口 org.springframework.security.web.authentication.AuthenticationSuccessHandler 的内部类实现
            final Object principal = authentication.getPrincipal();//用户信息
            final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//权限和角色信息
            final Object details = authentication.getDetails();
            final String json = client.queryJson(principal);
            client.responseJson(json,response);
        })
        //.successForwardUrl("/succeed")//登录成功的跳转url,其实它的服务端跳转,即URL路径不变,它是post请求方式;它有个特点就是不管你哪一个url页面过来，登录成功后都会跳转到/succeed
        //.defaultSuccessUrl("/success")//登录成功的重定向,它是重定向!!!,不是跳转,它会在登录成功后重定向到之前跳转过来的url页面,说明它会记录重定向的url地址;它会从哪里来就跳转哪里去,若在登录页面来的它会跳转到/success去;是get请求;它和successForwardUrl()不能同时使用,即只能二选一
        //.defaultSuccessUrl("/success",true)//这个重载的方法会和successForwardUrl一样的效果;

        //失败的回调,request可以客户端跳转[重定向];response可以服务器端跳转,当然可以返回json;authenticationException包含登录失败的数据信息;此时不会跳转了,要跳转只需在客户端做处理即可;
        .failureHandler((request,response,authenticationException)->{//它是接口 org.springframework.security.web.authentication.AuthenticationFailureHandler 内部类实现
            final String message = authenticationException.getMessage();
            if(authenticationException instanceof LockedException){
                client.responseJson(client.json(199,"账号被锁定"),response);
                return;
            }
            if(authenticationException instanceof CredentialsExpiredException){
                client.responseJson(client.json(199,"密码已过期"),response);
                return;
            }
            if(authenticationException instanceof AccountExpiredException){
                client.responseJson(client.json(199,"账号已过期"),response);
                return;
            }
            if(authenticationException instanceof DisabledException){
                client.responseJson(client.json(199,"账号被禁用"),response);
                return;
            }
            client.responseJson(client.json(199,message+"帐号或密码错误"),response);//返回:{"msg":"Bad credentials","code":199}
        })
        //.failureUrl("/failure")//登录失败的回调;它的重定向(重定向是客户端跳转)
        //.failureForwardUrl("/fail")//登录失败时回调;它是服务端跳转;
        .permitAll()//表示与登录相关的都统统放行[不包含css样式及图片,包含登录页面url;登录接口url;登录失败的回调url；登录成功的回调url]

        .and()//此时又回到上面第1行的 'authorizeRequests()'
        .logout()//配置退出登录
        .logoutUrl("/exit")//退出登录的url,默认是get方式,若要该成post方式请用下面方式处理
        //.logoutRequestMatcher(new AntPathRequestMatcher("/exit","POST"))
        //.logoutSuccessUrl("/login.html")//退出成功的处理
        .logoutSuccessHandler((request,response,authentication)->{//实现接口 org.springframework.security.web.authentication.logout.LogoutSuccessHandler 内部类
            final String json = client.json(200,"退出注销成功");
            client.responseJson(json,response);
        })
        //.invalidateHttpSession(true)//是否让Session失败,默认是true
        //.clearAuthentication(true)//清除认证登录信息,默认是true
        .permitAll()//表示与退出相关的都统统放行

        .and()//此时又回到上面第1行的 'authorizeRequests()'
        .csrf()
        .disable()
        //未登录认证处理
        .exceptionHandling()
        .authenticationEntryPoint((request,response,authException)->{
            client.responseJson(client.json(401,"尚未登录,请登录!"),response);
        });
    }
}