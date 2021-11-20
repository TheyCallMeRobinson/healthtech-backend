package team.healthtech.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import team.healthtech.db.provider.UserSecurityProvider;
import team.healthtech.security.handler.HealthtechAccessDeniedHandler;
import team.healthtech.security.handler.HealthtechFailureHandler;
import team.healthtech.security.handler.HealthtechSuccessHandler;
import team.healthtech.security.impl.UserDetailsServiceImpl;
import team.healthtech.service.security.ProfileMapper;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserSecurityProvider userSecurityProvider;
    private final ProfileMapper profileMapper;

    @Autowired
    public SecurityConfiguration(
        UserSecurityProvider userSecurityProvider,
        ProfileMapper profileMapper
    ) {
        this.userSecurityProvider = userSecurityProvider;
        this.profileMapper = profileMapper;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean());
        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        auth.authenticationProvider(daoAuthenticationProvider);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(userSecurityProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        final var urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final var config = new CorsConfiguration();
        config.setAllowCredentials(true); //разрешаем передавать ключи
        config.addAllowedOrigin("*"); // разрешаем запросы с любого домена
        config.addAllowedHeader("*"); // разрешаем передавать любые заголовки
        for (var method: List.of(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.HEAD))
            config.addAllowedMethod(method); // разрешаем http-методы

        config.addExposedHeader("*"); // разрешаем возвращать все заголовки
        urlBasedCorsConfigurationSource.registerCorsConfiguration("*", config); // разрешаем на любой API
        return urlBasedCorsConfigurationSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().configurationSource(corsConfigurationSource()).and()// какие сайты вообще смогут обращаться к приложению, без нее 403
            .csrf().disable() // защита от Cross-Site Request Forgery
            .logout()
            .logoutUrl("/user/logout")
            .and()
            .formLogin()
            .loginProcessingUrl("/user/login")
            .successHandler(new HealthtechSuccessHandler(userSecurityProvider, profileMapper))
            .failureHandler(new HealthtechFailureHandler())

            .and()
            .authorizeRequests()
            .mvcMatchers(HttpMethod.POST, "/user/login").not().authenticated()
            .anyRequest().permitAll()//.*/fullyAuthenticated()
            .and()
            .exceptionHandling().accessDeniedHandler(new HealthtechAccessDeniedHandler())
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        ;
    }

}
