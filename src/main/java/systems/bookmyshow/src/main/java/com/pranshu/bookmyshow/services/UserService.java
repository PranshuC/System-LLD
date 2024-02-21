package com.pranshu.bookmyshow.services;

import com.pranshu.bookmyshow.models.User;
import com.pranshu.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public User getUser(Long id) {
        System.out.println("Fetching user with id: " + id);
        return repository.getReferenceById(id);
    }

    public User createUser(User user) {
        System.out.println("Creating user with email: " + user.getEmail());
        return repository.save(user);
    }
}
