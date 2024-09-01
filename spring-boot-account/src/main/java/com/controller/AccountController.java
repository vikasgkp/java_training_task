package com.controller;

import com.service.AccountService;
import com.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
     AccountService accountService;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("account", new Account());
        return "createAccount";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account, Model model) {
        String result = accountService.createAccount(account);
        model.addAttribute("message", result);
        return "result";
    }

    @RequestMapping(value = "/deposit",method = RequestMethod.GET)
    public String showDepositForm(Model model) {
        model.addAttribute("accno", "");
        model.addAttribute("amount", "");
        model.addAttribute("panNumber", "");
        return "deposit";
    }

    @RequestMapping(value = "/deposit",method = RequestMethod.POST)
    public String deposit(@RequestParam int accno, @RequestParam double amount, @RequestParam(required = false) String panNumber, Model model) {
        String result = accountService.deposit(accno, amount, panNumber);
        model.addAttribute("message", result);
        return "result";
    }

    @RequestMapping(value = "/withdraw",method = RequestMethod.GET)
    public String showWithdrawForm(Model model) {
        model.addAttribute("accno", "");
        model.addAttribute("amount", "");
        return "withdraw";
    }

    @RequestMapping(value = "/withdraw",method = RequestMethod.POST)
    public String withdraw(@RequestParam int accno, @RequestParam double amount, Model model) {
        String result = accountService.withdraw(accno, amount);
        model.addAttribute("message", result);
        return "result";
    }

    @RequestMapping(value = "/balance",method = RequestMethod.GET)
    public String showBalanceForm(Model model) {
        model.addAttribute("accno", "");
        return "balance";
    }

    @RequestMapping(value = "/balance",method = RequestMethod.POST)
    public String checkBalance(@RequestParam int accno, Model model) {
        try {
            double balance = accountService.checkBalance(accno);
            model.addAttribute("balance", balance);
        } catch (RuntimeException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "balanceResult";
    }
}
