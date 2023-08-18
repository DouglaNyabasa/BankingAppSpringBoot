//package com.example.bankingApp.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests(
//                        (request) -> {
//                            try {
//                                request.antMatchers(
//                                                "/**/authenticate",
//                                                "/**/register",
//                                                "/api/access/**",
//                                                "/h2-console/**",
//                                                "/v2/api-docs",
//                                                "/v3/api-docs",
//                                                "/v3/api-docs/**",
//                                                "/swagger-resources",
//                                                "/swagger-resources/**",
//                                                "/configuration/ui",
//                                                "/configuration/security",
//                                                "/swagger-ui/**",
//                                                "/webjars/**",
//                                                "/swagger-ui.html")
//                                        .permitAll()
//                                        .anyRequest()
//                                        .authenticated()
//                                        .and()
//                                        .sessionManagement()
//                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                            } catch (Exception e) {
//                                e.printStackTrace();}}
//                ).authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .cors();
//        return http.build();
//    }
//
//
//}
