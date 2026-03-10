package com.gorani.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("-------------------filterChain--------------------");

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/sample/all").permitAll();            // 인증없이 모두 허용
            auth.requestMatchers("/sample/member").hasRole("USER");     // USER 권한이 있는 사용자만 허용 (인가)
            auth.requestMatchers("/member/mypage").authenticated();     // 로그인 후 가능 (인증 필요)
            auth.anyRequest().permitAll();              // 나머지 모든 URL은 인증없이 허용
        });

        http.formLogin(login->{
//            login.loginPage("/sample/login");
//            login.defaultSuccessUrl("/sample/all");
//            login.failureUrl("/sample/login");
        });

        // csrf
        http.csrf(AbstractHttpConfigurer::disable);

        // 로그아웃 설정
        http.logout(logout -> {
//            logout.logoutUrl("/sample/logout");
//            logout.logoutSuccessUrl("/sample/all");
        });

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        log.info("-------------------userDetailsService--------------------");
//
//        UserDetails user = User.builder()
//                .username("user1")
//                .password(passwordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
