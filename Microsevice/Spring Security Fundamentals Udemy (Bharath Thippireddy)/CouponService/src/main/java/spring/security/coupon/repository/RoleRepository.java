package spring.security.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.coupon.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
