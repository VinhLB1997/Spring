package spring.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springsecurity.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findByEmail(String email);
}
