package org.example.webdemoproject.repository;

import org.example.webdemoproject.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
