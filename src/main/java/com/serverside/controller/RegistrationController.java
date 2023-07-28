/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside.controller;

import com.serverside.model.Registration;
import com.serverside.service.RegistrationService;
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
@RequestMapping("api/registration")
public class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getAll(){
        return new ResponseEntity(registrationService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Registration> getById(@PathVariable Long id){
        return new ResponseEntity(registrationService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Registration> create(@RequestBody Registration registration) {
        return new ResponseEntity(registrationService.create(registration),HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Registration> Update(@PathVariable Long id,@RequestBody Registration registration){
        return new ResponseEntity(registrationService.update(id,registration), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Registration> Delete(@PathVariable Long id){
        return new ResponseEntity(registrationService.delete(id), HttpStatus.OK);
    }
}