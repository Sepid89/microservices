package com.sepidejd.accounts.repository;

import com.sepidejd.accounts.entity.Accounts;
import com.sepidejd.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Optional<Accounts> findByCustomerId(Long customerID);
}
