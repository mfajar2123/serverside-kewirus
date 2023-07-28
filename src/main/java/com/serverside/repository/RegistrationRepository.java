package com.serverside.repository;

import com.serverside.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
//    Optional<Registration> findByName(String registration);

}

