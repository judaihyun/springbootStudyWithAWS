package com.first.springboot.config.auth;

import com.first.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
       System.out.println("SecurityConfig - configure");
       http.csrf().disable().headers().frameOptions().disable().
               and().

               authorizeRequests().
               antMatchers("/","/css/**","/images/**",
                       "/js/**","/h2-console/**").permitAll().
               antMatchers("/api/v1/**").hasRole(Role.USER.name()).
               anyRequest().authenticated().

               and().
               logout().logoutSuccessUrl("/").

               and().
               oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);

    }
}
