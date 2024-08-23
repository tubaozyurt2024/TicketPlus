package com.patika.ticketplusservice.config;


import com.patika.ticketplusservice.security.JWTAccessDeniedHandler;
import com.patika.ticketplusservice.security.JwtAuthenticationEntryPoint;
import com.patika.ticketplusservice.security.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    private final JWTAccessDeniedHandler accessDeniedHandler;

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration
                                                               authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return  http
                .cors(Customizer.withDefaults()) // CORS yapılandırması
                .csrf(AbstractHttpConfigurer::disable) // CSRF yapılandırması
                .authorizeHttpRequests(auth -> {

                    auth.requestMatchers("/vehicles/**", "/tickets/{id}/total-price",
                            "/locations/**", "/expeditions/{id}/total-sales",
                            "/expeditions/post", "/expeditions/{id}").hasAuthority("ADMIN");
                    auth.requestMatchers("/users/**",
                            "/tickets", "/tickets/{id}", "/tickets/user-tickets/{id}",
                            "/passenger/**", "/confirmations/**", "/expeditions/date/{date}",
                            "/expeditions/vehicleTypes/{vehicleType}", "/expeditions/from/{from}/to/{to}",
                            "/expeditions/get/{id}", "/expeditions").hasAnyAuthority("ADMIN", "USER");
//                    auth.requestMatchers("/login", "/register").permitAll();
                    auth.anyRequest().permitAll();
                })
                .formLogin(AbstractHttpConfigurer::disable) // Form tabanlı kimlik doğrulama devre dışı
                .httpBasic(AbstractHttpConfigurer::disable) // Basic kimlik doğrulama devre dışı
                .exceptionHandling(exceptions -> {
                    exceptions.accessDeniedHandler(accessDeniedHandler)
                            .authenticationEntryPoint(authenticationEntryPoint);
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers( "/login", "/register");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }
}
