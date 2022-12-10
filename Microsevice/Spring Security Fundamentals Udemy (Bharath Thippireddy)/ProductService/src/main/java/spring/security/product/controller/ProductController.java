package spring.security.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.security.product.dto.CouponDTO;
import spring.security.product.entity.Product;
import spring.security.product.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final String CouponServiceURL = "http://localhost:9000/coupons/";
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        CouponDTO couponDTO = restTemplate.getForObject(CouponServiceURL + product.getCouponCode(), CouponDTO.class);
        product.setPrice(product.getPrice().subtract(couponDTO.getDiscount()));
        return productRepository.save(product);
    }
}
