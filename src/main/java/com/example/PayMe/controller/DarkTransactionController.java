package com.example.PayMe.controller;

import ch.qos.logback.core.model.Model;
import com.example.PayMe.service.DarkTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DarkTransactionController {

    @Autowired
    DarkTransactionService darkTransactionService;

    @GetMapping("/darkTransactions")
    public String getDarkTransactionsPage(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("darkTransactions", darkTransactionService.getDarkTransactionsListByUserName(userName));
        return "darkTransactionsPage";
    }
}
