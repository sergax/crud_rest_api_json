package com.sergax.crudrestapi.service.serviceImplementation;

import com.sergax.crudrestapi.model.Event;
import com.sergax.crudrestapi.repository.hibernateRepositoryImplementation.EventRepositoryImplementation;
import com.sergax.crudrestapi.service.EventService;

import java.util.List;

public class EventServiceImplementation implements EventService {
    private EventRepositoryImplementation eventRepositoryImplementation =
            new EventRepositoryImplementation();

    @Override
    public List<Event> getAll() {
        return eventRepositoryImplementation.getAll();
    }

    @Override
    public Event getById(Long id) {
        return eventRepositoryImplementation.getById(id);
    }

    @Override
    public void create(Event event) {
        eventRepositoryImplementation.create(event);
    }

    @Override
    public void update(Event event) {
        eventRepositoryImplementation.update(event);
    }

    @Override
    public boolean delete(Long id) {
        return eventRepositoryImplementation.delete(id);
    }
}
