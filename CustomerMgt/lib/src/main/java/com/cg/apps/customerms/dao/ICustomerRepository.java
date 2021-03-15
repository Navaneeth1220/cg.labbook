package com.cg.apps.customerms.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customerms.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
