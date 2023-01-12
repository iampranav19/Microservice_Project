package com.pranav.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.entity.TransactionDetails;

@Repository
public interface PaymentRepo extends JpaRepository<TransactionDetails, Long> {

}
