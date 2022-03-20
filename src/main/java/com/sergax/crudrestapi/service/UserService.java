package com.sergax.crudrestapi.service;

import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.repository.hibernateRepositoryImplementation.UserRepositoryImplementation;

public interface UserService extends GenericService<Long, User> {
}
