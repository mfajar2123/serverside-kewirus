/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside.controller;

import com.serverside.model.Event;
import com.serverside.service.EventService;
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
@RequestMapping("api/event")
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return new ResponseEntity(eventService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id){
        return new ResponseEntity(eventService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return new ResponseEntity(eventService.create(event),HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Event> Update(@PathVariable Long id,@RequestBody Event event){
        return new ResponseEntity(eventService.update(id,event), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Event> Delete(@PathVariable Long id){
        return new ResponseEntity(eventService.delete(id), HttpStatus.OK);
    }
}