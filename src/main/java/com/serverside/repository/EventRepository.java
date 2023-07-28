package com.serverside.repository;

import com.serverside.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
//    Optional<Event> findByName(String event);

}

