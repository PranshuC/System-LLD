package com.pranshu.splitwise.services;

import com.pranshu.splitwise.dtos.CreateUserDto;
import com.pranshu.splitwise.models.User;
import com.pranshu.splitwise.repositories.UserRepository;
import com.pranshu.splitwise.interfaces.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private PasswordEncoder encoder;

    public User createUser(CreateUserDto request) {
        // Hash the plaintext password
        String hashedPassword = encoder.encode(request.getPassword());
        // Map DTO to model
        User user = request.user(hashedPassword);
        // Store in the database
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getUsers(Set<Long> userIds) {
        return repository.findAllById(userIds);
    }
}
