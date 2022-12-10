package spring.security.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.security.coupon.entity.Coupon;
import spring.security.coupon.repository.CouponRepository;

import java.util.Optional;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponRepository couponRepository;

    @GetMapping("/{code}")
    public Optional<Coupon> findByCode(@PathVariable String code){
        return couponRepository.findByCode(code);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }
}
