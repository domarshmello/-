package org.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * WebSecurityConfig只包含有关如何验证我们的用户的信息
 * 使用WebSecurityConfigurerAdapter时，会自动应用注销功能。
 * 默认情况下，访问URL /logout将通过以下方式记录用户：
 * 使HTTP session无效
 * 清除配置的任何RememberMe身份验证
 * 清除 SecurityContextHolder
 * 跳转至 /login?logout
 * 在没有自定义登录页面之前，SpringSecurity会自动生成登录页面
 */
@Configuration // 声明为配置类
@EnableWebSecurity// 启用 Spring Security web 安全的功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //暂时使用基于内存的AuthenticationProvider
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_name, user_pass, true from t_user where user_name=?")
                .authoritiesByUsernameQuery("select user_name, role from t_user where user_name=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // ingore是完全绕过了spring security的所有filter，相当于不走spring security
        // 针对 static 资源忽略认证
        web.ignoring().antMatchers("/static/**");
    }

    /**
     * Spring Security知道我们要支持基于表单的身份验证？------- 验证请求
     * 其原因是WebSecurityConfigurerAdapter在configure(HttpSecurity http)方法中提供了一个默认配置
     * 确保对我们的应用程序的任何请求需要用户进行身份验证
     * 允许用户使用基于表单的登录进行身份验证
     * 允许用户使用HTTP Basic进行身份验证
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 跨站点请求伪造（CSRF)  CSRF令牌   WebSecurityConfigurerAdapter时的默认构造方法时CSRF是激活
         * http.authorizeRequests()方法添加多个子节点来指定我们的URL的自定义要求
         * http.authorizeRequests()方法有多个子节点，每个匹配器都按它们声明的顺序考虑
         *
         * WebSecurity主要是配置跟web资源相关的，比如css、js、images等等，但是这个还不是本质的区别，关键的区别如下：
         * permitall没有绕过spring security，其中包含了登录的以及匿名的。
         *
         */
        //暂时禁用csrf,并自定义登录页和登出URL
        http.csrf().disable()   // 禁用 Spring Security 自带的csrf跨域处理
                .authorizeRequests()
                //.anyRequest().permitAll();  // 允许所有请求通过
                .anyRequest().authenticated()
                .and()
                .formLogin().and();
    }
}