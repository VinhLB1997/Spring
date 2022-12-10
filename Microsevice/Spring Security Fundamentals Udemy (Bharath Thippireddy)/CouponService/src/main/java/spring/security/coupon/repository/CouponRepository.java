package spring.security.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.coupon.entity.Coupon;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCode(String code);
}
