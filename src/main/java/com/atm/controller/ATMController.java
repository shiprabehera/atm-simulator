package com.atm.controller;

import com.atm.dao.Account;
import com.atm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ATMController {

    @Autowired
    AccountService accountService;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("View Balance", "Withdraw", "Deposit", "Transfer", "Exit");

    private String custName; 
    private Account theAccount;
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        custName = name;

        model.addAttribute("message", custName);
        return "welcome"; //view
    }

    @PostMapping("/login")
    public String greetingSubmit(@RequestParam(name = "accountnum", required = true) Integer accNum,Model model) {

        theAccount = accountService.getAccountByAccountNo(accNum);
        if (accountService.getAllAccounts().contains(theAccount)) {
            int custId = theAccount.getUserId();
            model.addAttribute("Text", "Please choose an option, User " + custId);
            return "menu";
        }

        else {

            model.addAttribute("error", "Please enter the correct Account number");    
            return "welcome";
            
        }
    }

    @GetMapping("/balance")
    public String mainBalance(Model model) {
        
        float bal = theAccount.getBalance();
        model.addAttribute("balance", bal);    
        return "balance"; //view
    }


    @GetMapping("/withdraw")
    public String menu(Model model) {
        return "withdrawal"; //view
    }


    @GetMapping("/accounts")
    private String getAllAccounts(Model model) {
        List<Account> accounts = accountService.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "welcome";
    }

}