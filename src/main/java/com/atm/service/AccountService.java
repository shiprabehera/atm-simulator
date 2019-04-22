package com.atm.service;

import com.atm.dao.Account;
import com.atm.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        accountRepository.findAll().forEach(account -> accounts.add(account));
        return accounts;
    }

    public Account getAccountByAccountNo(int accNo) {
        Account account = accountRepository.findByAccountNo(accNo);
        return account;
    }

    public void saveOrUpdate(Account account) {
        accountRepository.save(account);
    }

    public void delete(int acc_num) {
        accountRepository.deleteById(acc_num);
    }

    public int checkLogin(Account formAccount) {
        Account account = getAccountByAccountNo(formAccount.getAccountNo());
        if (account == null || account.getPin() != formAccount.getPin()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public boolean makeTransfer(int originAccNo, int targetAccNo, float amount) {
        Account origAccount = getAccountByAccountNo(originAccNo);
        Account targetAccount = getAccountByAccountNo(targetAccNo);
        float remaining = origAccount.getBalance() - amount;
        if (remaining >= 0) {
            origAccount.setBalance(remaining);
            targetAccount.setBalance(targetAccount.getBalance() + amount);
            saveOrUpdate(origAccount);
            saveOrUpdate(targetAccount);
            return true;
        } else {
            return false;
        }
    }


}
