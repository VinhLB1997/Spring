package spring.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.springsecurity.entity.CustomerEntity;
import spring.springsecurity.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<CustomerEntity> customerFind = customerRepository.findByEmail(email);
        CustomerEntity customerAuthentication = null;
        List<GrantedAuthority> roles = new ArrayList<>();
        if(!customerFind.isPresent()){
            throw new UsernameNotFoundException("User not found!");
        } else {
            customerAuthentication = customerFind.get();
            roles.add(new SimpleGrantedAuthority(customerAuthentication.getRole()));
        }
        return new User(customerAuthentication.getEmail(), customerAuthentication.getPassword(), roles);
    }
}
