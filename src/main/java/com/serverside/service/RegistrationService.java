
package com.serverside.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serverside.model.Registration;
import com.serverside.repository.RegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration getById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registration dengan id " + id + " tidak ditemukan!!"));
    }

    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

//    public Registration create(Registration registration) {
//        Registration existingRegistration = registrationRepository.findByName(registration.getRegistration().getTitle()).orElse(null);
//        if (existingRegistration == null && registration.getId() == null) {
//            return registrationRepository.save(registration);
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama registration sudah ada!");
//        }
//    }

    public Registration create(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration update(Long id, Registration registration) {
        getById(id);
        registration.setId(id);
        return registrationRepository.save(registration);
    }

    public Registration delete(Long id) {
        Registration registration = getById(id);
        registrationRepository.delete(registration);
        return registration;
    }

}

