package spring.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

//    @Autowired
//    MyAuthenticationProvider myAuthenticationProvider;
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
//                .authenticationProvider(myAuthenticationProvider).build();
//
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.formLogin();
//        httpSecurity.authorizeRequests().anyRequest().authenticated();
//        return httpSecurity.build();
//    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.formLogin();
//        http.httpBasic();
        http.authorizeRequests().antMatchers("/accounts", "/balance", "/cards").authenticated()
                .antMatchers("/notices","/loans").permitAll()
                .and().httpBasic().and().formLogin();
        return http.build();
    }
}
