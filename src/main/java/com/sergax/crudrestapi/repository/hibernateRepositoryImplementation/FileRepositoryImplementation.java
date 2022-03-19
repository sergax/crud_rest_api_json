package com.sergax.crudrestapi.repository.hibernateRepositoryImplementation;

import com.sergax.crudrestapi.model.Event;
import com.sergax.crudrestapi.model.File;
import com.sergax.crudrestapi.repository.FileRepository;
import org.hibernate.Transaction;

import java.util.List;

public class FileRepositoryImplementation implements FileRepository {
    private Transaction transaction = null;
    private File file = null;

    @Override
    public List<Event> getAll() {
        return null;
    }

    @Override
    public Event getById(Long aLong) {
        return null;
    }

    @Override
    public void create(Event event) {

    }

    @Override
    public void update(Event event) {

    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }
}
