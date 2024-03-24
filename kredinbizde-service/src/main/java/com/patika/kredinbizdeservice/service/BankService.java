package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getAll() {
        return bankRepository.getAll();
    }

    public List<CreditCard> getAllCreditCards(String bankName) {
        return bankRepository.getAllCreditCards(bankName);
    }

    public List<Campaign> getAllCreditCardCampaigns(String bankName) {
        return bankRepository.getAllCreditCardCampaigns(bankName);
    }

    public Bank findByName(String name) {
        Optional<Bank> optinalBank = bankRepository.findByName(name);

        Bank bank = null;

        if(optinalBank.isPresent()) {
            bank = optinalBank.get();
        }

        return bank;
    }

    public void saveApplication(Bank bank) {
        bankRepository.save(bank);
    }

    public Bank update(String bankName, Bank bank) {

        Optional<Bank> foundBank = bankRepository.findByName(bankName);

        foundBank.get().setCreditCards(bank.getCreditCards());

        foundBank.get().setName(bank.getName());

        foundBank.get().setLoanList(bank.getLoanList());

        bankRepository.delete(bank);

        bankRepository.save(foundBank.get());

        return foundBank.get();
    }

    public void deleteApplication(Bank bank) {
        bankRepository.delete(bank);
    }
}
