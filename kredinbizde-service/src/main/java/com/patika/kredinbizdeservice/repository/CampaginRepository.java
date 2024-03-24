package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Campaign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CampaginRepository {

    private List<Campaign> campaignList = new ArrayList<>();

    public List<Campaign> getAllCampaignSorted() {
        return campaignList.stream()
                .sorted(Comparator.comparing(Campaign::getCreateDate).reversed())
                .toList();
    }
}
