package com.fsse2506.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**").permitAll()  // ✅ Allow public access
//                        .anyRequest().authenticated()              // 🔐 Require auth for others
//                )
//                .anonymous(Customizer.withDefaults())       // ✅ Allow anonymous users
//                .csrf(csrf -> csrf.disable())
//                .oauth2ResourceServer(oauth2 ->
//                        oauth2.jwt(Customizer.withDefaults())
//                );
//        return http.build();
//    }
//}

        // Public endpoints - no authentication required
        @Bean
        @Order(1)
        public SecurityFilterChain publicFilterChain(HttpSecurity http) throws Exception {
            http
                    .securityMatcher("/public/**")
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()
                    )
                    .anonymous(Customizer.withDefaults())
                    .csrf(csrf -> csrf.disable());
            return http.build();
        }

        // Protected endpoints - authentication required
        @Bean
        @Order(2)
        public SecurityFilterChain protectedFilterChain(HttpSecurity http) throws Exception {
            http
                    .securityMatcher("/**")
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().authenticated()
                    )
                    .csrf(csrf -> csrf.disable())
                    .oauth2ResourceServer(oauth2 ->
                            oauth2.jwt(Customizer.withDefaults())
                    );
            return http.build();
        }
    }