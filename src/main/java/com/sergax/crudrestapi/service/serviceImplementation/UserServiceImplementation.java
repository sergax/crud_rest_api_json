package com.sergax.crudrestapi.service.serviceImplementation;

import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.repository.hibernateRepositoryImplementation.UserRepositoryImplementation;
import com.sergax.crudrestapi.service.UserService;

import java.util.List;

public class UserServiceImplementation implements UserService {
    private final UserRepositoryImplementation userRepositoryImplementation =
            new UserRepositoryImplementation();

    @Override
    public List<User> getAll() {
        return userRepositoryImplementation.getAll();
    }

    @Override
    public User getById(Long id) {
        return userRepositoryImplementation.getById(id);
    }

    @Override
    public void create(User user) {
        userRepositoryImplementation.create(user);
    }

    @Override
    public void update(User user) {
        userRepositoryImplementation.update(user);
    }

    @Override
    public boolean delete(Long id) {
        return userRepositoryImplementation.delete(id);
    }
}
