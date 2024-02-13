package ru.mihail.spring.ispi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
   public UserDetailsService userDetailsService(PasswordEncoder encoder){
       UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).build();
        UserDetails doctor = User.builder().username("doctor").password(encoder.encode("doctor")).build();
        UserDetails patient = User.builder().username("patient").password(encoder.encode("patient")).build();

        return new InMemoryUserDetailsManager(admin, doctor, patient);
   }

   @Bean
   public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }
}