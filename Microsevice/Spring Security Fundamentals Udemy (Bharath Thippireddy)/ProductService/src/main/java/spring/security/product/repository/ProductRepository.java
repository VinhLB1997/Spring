package spring.security.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
