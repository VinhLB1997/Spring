package spring.springaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springaop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
