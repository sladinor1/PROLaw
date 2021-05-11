package com.prolaw.configuration;


import com.prolaw.OAuth.CustomOAuth2User;
import com.prolaw.OAuth.CustomOAuth2UserService;
import com.prolaw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private HttpServletResponse response;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/","/login","/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .oauth2Login()
                   .loginPage("/login")
                   .userInfoEndpoint()
                        .userService(oauth2UserService)
                   .and()
                   .successHandler(new AuthenticationSuccessHandler() {
                       @Override
                       public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

                           CustomOAuth2User oAuthUser = (CustomOAuth2User) authentication.getPrincipal();
                           UserService.processOAuthPostLogin(oAuthUser.getEmail());
                           response.sendRedirect("/list");
                       }
                   })
                .and()
                .csrf().disable();
    }

    @Autowired
    private CustomOAuth2UserService oauth2UserService;

}
