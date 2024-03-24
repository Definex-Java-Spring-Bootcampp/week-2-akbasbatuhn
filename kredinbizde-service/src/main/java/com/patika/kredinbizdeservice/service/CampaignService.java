package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.CampaginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final CampaginRepository repository;

    public CampaignService(CampaginRepository repository) {
        this.repository = repository;
    }

    public List<Campaign> getAllCampaignSorted() {
        return repository.getAllCampaignSorted();
    }
}
