package com.serverside.repository;

import com.serverside.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
//    Optional<Advertisement> findByName(String advertisement);

}

