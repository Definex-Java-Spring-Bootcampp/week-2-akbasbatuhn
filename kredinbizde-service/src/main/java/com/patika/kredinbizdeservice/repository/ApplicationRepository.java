package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();

    public List<Application> getAllApplicationsByEmail(String email) {
        return applicationList.stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .toList();
    }

    public List<Application> getAll() {
        return applicationList;
    }

    public Optional<Application> findByEmail(String email) {
        return applicationList.stream()
                .filter(app -> app.getUser().getEmail().equals(email))
                .findFirst();
    }

    public void save(Application application) {
        applicationList.add(application);
    }

    public void delete(Application application) {
        applicationList.remove(application);
    }
}
