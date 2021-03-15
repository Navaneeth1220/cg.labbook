package com.cg.apps.customerms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customerms.entity.Account;

public interface IAccountRepository extends JpaRepository<Account,Long> {

}
