package com.platform.isl_backend.Config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.platform.isl_backend.Config.JwtTokenValidator;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity object for configuration
     * @return the configured SecurityFilterChain
     * @throws Exception if any configuration error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless applications
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Public endpoints
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .cors(cors -> cors.configurationSource(corsConfigurationSource())); // Enable CORS with custom configuration

        // Add JWT filter
        http.addFilterBefore(jwtTokenValidator(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Provides a bean for the JwtTokenValidator filter.
     *
     * @return JwtTokenValidator object
     */
    @Bean
    public JwtTokenValidator jwtTokenValidator() {
        return new JwtTokenValidator();
    }

    /**
     * Configures CORS settings.
     *
     * @return CorsConfigurationSource object
     */
    private CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("http://localhost:5500",
                    "http://localhost:5500",
                    "http://localhost:5501",
                    "http://127.0.0.1:5500",
                    "http://127.0.0.1:5501",
                    "http://localhost:8080",
                    "http://localhost:8081"
            )); // Allowed origins
            configuration.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers
            configuration.setExposedHeaders(Arrays.asList("Authorization")); // Expose Authorization header
            configuration.setMaxAge(3600L); // Cache pre-flight response for 1 hour
            return configuration;
        };
    }

    /**
     * Provides a PasswordEncoder bean using BCrypt.
     *
     * @return PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
