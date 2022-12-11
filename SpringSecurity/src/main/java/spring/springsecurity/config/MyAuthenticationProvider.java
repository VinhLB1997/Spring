package spring.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.springsecurity.entity.CustomerEntity;
import spring.springsecurity.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String passwordAuth = authentication.getCredentials().toString();
        Optional<CustomerEntity> customerFound = customerRepository.findByEmail(email);
        if (customerFound.isPresent()) {
            if (passwordEncoder.matches(passwordAuth, customerFound.get().getPassword())) {
                List<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(customerFound.get().getRole()));
                return UsernamePasswordAuthenticationToken.authenticated(email, passwordAuth, roles);
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

        @Override
        public boolean supports (Class < ? > authentication){
            return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
        }
    }
