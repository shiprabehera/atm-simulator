package com.atm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.atm.dao.Account;

import java.util.List;

@Repository
public interface AccountDAO extends CrudRepository<Account, Integer>{
    public List<Account> findByAccountNo(int accountNo);

}
