package com.sms.smr.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sms.smr.security.auditing.ApplicationAuditAware;

import static com.sms.smr.domain.Permission.ADMIN_CREATE;
import static com.sms.smr.domain.Permission.ADMIN_DELETE;
import static com.sms.smr.domain.Permission.ADMIN_READ;
import static com.sms.smr.domain.Permission.ADMIN_UPDATE;
import static com.sms.smr.domain.Permission.MANAGER_CREATE;
import static com.sms.smr.domain.Permission.MANAGER_DELETE;
import static com.sms.smr.domain.Permission.MANAGER_READ;
import static com.sms.smr.domain.Permission.MANAGER_UPDATE;
import static com.sms.smr.domain.Role.ADMIN;
import static com.sms.smr.domain.Role.MANAGER;
import static com.sms.smr.domain.Role.PERSON;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration implements WebMvcConfigurer {

    private static final String[] WHITE_LIST_URL = {
        //"/api/v1/auth/register",
            "/error",
            //"/api/v1/auth/authenticate", 
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    //private final JwtAuthenticationFilter jwtAuthFilter;
    //private final AuthenticationProvider authenticationProvider;
    //private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(AbstractHttpConfigurer::disable)
        .cors(Customizer.withDefaults()) // Enable CORS
        .authorizeHttpRequests(req ->
                req.requestMatchers(
                                "/auth/**",
                                "/v2/api-docs",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-resources",
                                "/swagger-resources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-ui.html"
                        )
                            .permitAll()
                        .anyRequest()
                            .authenticated()
        )
        .oauth2ResourceServer(auth ->
                auth.jwt(token -> token.jwtAuthenticationConverter(new KeycloakJwtAuthenticationConverter())));
                

        return http.build();
    }
  
    @Bean
    public AuditorAware<String> auditorAware() {
        return (AuditorAware)new ApplicationAuditAware();
    }    

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:8081"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        //configuration.setMaxAge(Duration.ofSeconds(3600));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;        


    }    
}
