package com.example.logbackdemo.com.comf;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @program: source-demo
 * @description: 认证配置类
 * @ClassName：SecuritySecureConfig
 * @author: Mr.Wang
 * @create: 2022-02-21 11:05
 **/
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter  {

    /**
     * 应用上下文路径
     */
    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties){
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");
        http.authorizeRequests()
                /*** 1.配置所有的静态资源和登录页面可以访问*/
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                //2.其他请求必须要经过认证
                .anyRequest().authenticated()
                .and()
                //3.配置登录和登出路径
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
                .and()
                .logout().logoutUrl(adminContextPath + "logout")
                .and()
                //4.开启HTTP basic支持，其他服务注册时需要用
                .httpBasic()
                .and()
                //5.开启基于cookie的 csrf保护
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //6.忽略一下路径的csrf保护
                .ignoringAntMatchers(adminContextPath + "/instances",adminContextPath + "/actuator/");

    }
}
