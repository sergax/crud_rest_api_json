package com.sergax.crudrestapi.service.serviceImplementation;

import com.sergax.crudrestapi.model.File;
import com.sergax.crudrestapi.repository.hibernateRepositoryImplementation.FileRepositoryImplementation;
import com.sergax.crudrestapi.service.FileService;

import java.util.List;

public class FileServiceImplementation implements FileService {
    private final FileRepositoryImplementation fileRepositoryImplementation =
            new FileRepositoryImplementation();

    @Override
    public List<File> getAll() {
        return fileRepositoryImplementation.getAll();
    }

    @Override
    public File getById(Long id) {
        return fileRepositoryImplementation.getById(id);
    }

    @Override
    public void create(File file) {
        fileRepositoryImplementation.create(file);
    }

    @Override
    public void update(File file) {
        fileRepositoryImplementation.update(file);
    }

    @Override
    public boolean delete(Long id) {
        return fileRepositoryImplementation.delete(id);
    }
}
