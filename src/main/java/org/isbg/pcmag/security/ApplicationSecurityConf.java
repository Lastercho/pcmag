package org.isbg.pcmag.security;

import org.isbg.pcmag.auth.ApplicationUserService;
import org.isbg.pcmag.jwt.JwtConfig;
import org.isbg.pcmag.jwt.JwtTokenVerifier;
import org.isbg.pcmag.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.crypto.SecretKey;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConf extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConf(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService,
                                   SecretKey secretKey, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;

        this.jwtConfig = jwtConfig;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
    .csrf()
                    .disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*", "/login").permitAll()
                .antMatchers("/api/**").hasAnyRole()
                .anyRequest()
                .authenticated()
//        .and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .defaultSuccessUrl("http://localhost:4200/pc", true)
//            .passwordParameter("password")
//            .usernameParameter("username")
//        .and()
//        .rememberMe()
//            .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//            .key(secretKey.toString())
//            .rememberMeParameter("remember-me")
//        .and()
//        .logout()
//            .logoutUrl("/logout")
//            .logoutRequestMatcher(new AntPathRequestMatcher("logout", "GET"))
//            .clearAuthentication(true)
//            .invalidateHttpSession(true)
//            .deleteCookies("JSESSIONID", "remember-me")
//            .logoutSuccessUrl("/login")
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }


}
