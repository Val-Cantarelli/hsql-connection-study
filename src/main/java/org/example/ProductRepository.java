package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA é pra qualquer DB - é o manual universal do Java para DB
public interface ProductRepository extends JpaRepository<Product, Long> {
}
