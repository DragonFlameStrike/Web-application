package com.jarsoft.webapp.adverts.testtask.security;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private Environment env;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser(env.getProperty("spring.security.user.name"))
                .password(env.getProperty("spring.security.user.password"))
                .roles("ROOT");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){ return NoOpPasswordEncoder.getInstance(); }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().disable().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/root/**").hasRole("ROOT")
                .antMatchers("/api/**").hasRole("ROOT")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }
}
