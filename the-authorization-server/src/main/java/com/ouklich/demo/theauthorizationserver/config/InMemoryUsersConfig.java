package com.ouklich.demo.theauthorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUsersConfig {

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        var one = User.withDefaultPasswordEncoder().roles("admin").username("ilkou").password("pw").build();
        var two = User.withDefaultPasswordEncoder().roles("user").username("boot").password("pw").build() ;
        return new InMemoryUserDetailsManager(one, two);
    }
}
