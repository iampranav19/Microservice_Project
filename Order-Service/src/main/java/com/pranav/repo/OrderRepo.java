package com.pranav.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
