package com.pranav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

