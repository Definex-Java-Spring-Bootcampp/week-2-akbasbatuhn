package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAll() {
        return applicationRepository.getAll();
    }

    public List<Application> getAllApplication(String email) {
        return applicationRepository.getAllApplicationsByEmail(email);
    }

    public Application findByEmail(String email) {
        Optional<Application> app = applicationRepository.findByEmail(email);

        Application application = null;

        if(app.isPresent()) {
            application = app.get();
        }

        return application;
    }

    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    public Application update(String email, Application app) {

        Optional<Application> foundApplication = applicationRepository.findByEmail(email);

        foundApplication.get().setApplicationStatus(app.getApplicationStatus());

        foundApplication.get().setLoan(app.getLoan());

        foundApplication.get().setUser(app.getUser());

        foundApplication.get().setLocalDateTime(app.getLocalDateTime());

        applicationRepository.delete(app);

        applicationRepository.save(foundApplication.get());

        return foundApplication.get();
    }

    public void deleteApplication(Application application) {
        applicationRepository.delete(application);
    }
}
