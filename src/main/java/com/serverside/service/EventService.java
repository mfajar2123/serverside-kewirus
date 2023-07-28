
package com.serverside.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serverside.model.Event;
import com.serverside.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.BeanUtils;
import java.util.stream.Collectors;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event dengan id " + id + " tidak ditemukan!!"));
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

//    public Event create(Event event) {
//        Event existingEvent = eventRepository.findByName(event.getTitle()).orElse(null);
//        if (existingEvent == null && event.getId() == null) {
//            return eventRepository.save(event);
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama event sudah ada!");
//        }
//    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }


    public Event update(Long id, Event event) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        if (existingEvent != null) {
            // Menggunakan BeanUtils untuk menyalin properti dari updatedEvent ke existingEvent
            BeanUtils.copyProperties(event, existingEvent, "id", "createdAt");
            return eventRepository.save(existingEvent);
        }
        return null;
    }

    public Event delete(Long id) {
        Event event = getById(id);
        eventRepository.delete(event);
        return event;
    }

    public List<Event> getSeminars() {
        List<Event> allEvents = eventRepository.findAll();
        return allEvents.stream()
                .filter(event -> event.getCategory().equalsIgnoreCase("Seminar"))
                .collect(Collectors.toList());
    }

    public List<Event> getCompetitions() {
        List<Event> allEvents = eventRepository.findAll();
        return allEvents.stream()
                .filter(event -> event.getCategory().equalsIgnoreCase("Lomba"))
                .collect(Collectors.toList());
    }

}

