package com.service;

import com.entity.Account;
import com.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    @Autowired
     AccountRepository accountRepository;

    public String createAccount(Account account) {
        if (account.getAmount() <= 1000) {
            return "Amount must be greater than 1000";
        }
        if (accountRepository.findByAccno(account.getAccno()) != null) {
            return "Account number must be unique";
        }
        accountRepository.save(account);
        return "Account created successfully";
    }

    public String deposit(int accno, double amount, String panNumber) {
        Account account = accountRepository.findByAccno(accno);
        if (account == null) {
            return "Account not found";
        }
        if (amount > 50000) {
           
            return "Deposits over 50,000 require PAN number";
        }
        account.setAmount(account.getAmount() + amount);
        accountRepository.save(account);
        return "Deposit successful";
    }

    public String withdraw(int accno, double amount) {
        Account account = accountRepository.findByAccno(accno);
        if (account == null) {
            return "Account not found";
        }
        if (account.getAmount() - amount < 1000) {
            return "Insufficient funds. Minimum balance must be 1000";
        }
        account.setAmount(account.getAmount() - amount);
        accountRepository.save(account);
        return "Withdrawal successful";
    }

    public double checkBalance(int accno) {
        Account account = accountRepository.findByAccno(accno);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        return account.getAmount();
    }
}
