package com.sakshem.springsecuritywithh2database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


// this tells spring security that this is a web security configuration.
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    // constructor injection
    @Autowired
    public SecurityConfiguration(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // JDBC authentication with h2 database for development and testing
        // Option 1: using default schema
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser(
//                        User.withUsername("john")
//                                .password("test123")
//                                .roles("USER")
//                )
//                .withUser(
//                       User.withUsername("sakshem")
//                               .password("test123")
//                               .roles("ADMIN")
//                );

        // Option 2: using custom schema using sql files in resources directory
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
         return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // order should be from most restrictive URL to least
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
