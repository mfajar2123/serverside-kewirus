
package com.serverside.service;

import java.util.List;

import com.serverside.model.Advertisement;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serverside.repository.AdvertisementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement getById(Long id) {
        return advertisementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement dengan id " + id + " tidak ditemukan!!"));
    }

    public List<Advertisement> getAll() {
        return advertisementRepository.findAll();
    }

//    public Advertisement create(Advertisement advertisement) {
//        Advertisement existingAdvertisement = advertisementRepository.findByName(advertisement.getTitle()).orElse(null);
//        if (existingAdvertisement == null && advertisement.getId() == null) {
//            return advertisementRepository.save(advertisement);
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama advertisement sudah ada!");
//        }
//    }

    public Advertisement create(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public Advertisement update(Long id, Advertisement advertisement) {
        Advertisement existingAdvertisement = advertisementRepository.findById(id).orElse(null);
        if (existingAdvertisement != null) {
            // Menggunakan BeanUtils untuk menyalin properti dari updatedAdvertisement ke existingAdvertisement
            BeanUtils.copyProperties(advertisement, existingAdvertisement, "id", "createdAt");
            return advertisementRepository.save(existingAdvertisement);
        }
        return null;
    }

    public Advertisement delete(Long id) {
        Advertisement advertisement = getById(id);
        advertisementRepository.delete(advertisement);
        return advertisement;
    }

}

