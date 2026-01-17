package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for Product persistence.
 * Provides CRUD operations via Spring Data JPA.
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
}
