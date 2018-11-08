package com.app.reservation.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                "/**/**"
            ).permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf()
            .ignoringAntMatchers("/console/**"
                ,"/swagger-resources"
                ,"/configuration/security"
                ,"/swagger-ui.html"
                ,"/webjars/**"
                ,"/swagger/**"
                ,"/reservation/v1/room/**"
            )
            .and()
            .headers().frameOptions().sameOrigin()
        ;
    }


}