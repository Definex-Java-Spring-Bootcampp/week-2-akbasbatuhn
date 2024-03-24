package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{bankName}/creditCards")
    public ResponseEntity<List<CreditCard>> getAllCreditCardsByBankName(@PathVariable String bankName) {
        return ResponseEntity.ok().body(bankService.getAllCreditCards(bankName));
    }

    @GetMapping("/{bankName}/creditCards/campaigns")
    public ResponseEntity<List<Campaign>> getAllCreditCardCampaignsByBankName(@PathVariable String bankName) {
        return ResponseEntity.ok().body(bankService.getAllCreditCardCampaigns(bankName));
    }
}
