/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside.controller;

import com.serverside.model.Advertisement;
import com.serverside.service.AdvertisementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/advertisement")
public class AdvertisementController {
    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping
    public ResponseEntity<List<Advertisement>> getAll(){
        return new ResponseEntity(advertisementService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getById(@PathVariable Long id){
        return new ResponseEntity(advertisementService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Advertisement> create(@RequestBody Advertisement advertisement) {
        return new ResponseEntity(advertisementService.create(advertisement),HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> Update(@PathVariable Long id,@RequestBody Advertisement advertisement){
        return new ResponseEntity(advertisementService.update(id,advertisement), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Advertisement> Delete(@PathVariable Long id){
        return new ResponseEntity(advertisementService.delete(id), HttpStatus.OK);
    }
}