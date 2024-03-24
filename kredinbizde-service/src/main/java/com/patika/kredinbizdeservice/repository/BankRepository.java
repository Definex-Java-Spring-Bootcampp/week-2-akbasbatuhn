package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BankRepository {

    private List<Bank> bankList = new ArrayList<>();

    public List<Bank> getAll() {
        return bankList;
    }

    public List<CreditCard> getAllCreditCards(String bankName) {
        List<CreditCard> creditCards = new ArrayList<>();

        bankList.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .forEach(bank -> creditCards.addAll(bank.getCreditCards()));

        return creditCards;
    }

    public List<Campaign> getAllCreditCardCampaigns(String bankName) {
        List<Campaign> campaigns = new ArrayList<>();

        getAllCreditCards(bankName).stream()
                .forEach(card -> campaigns.addAll(card.getCampaignList()));

        return campaigns;
    }

    public Optional<Bank> findByName(String bankName) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst();
    }

    public void save(Bank bank) {
        bankList.add(bank);
    }

    public void delete(Bank bank) {
        bankList.remove(bank);
    }
}
