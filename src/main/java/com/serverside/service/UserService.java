
package com.serverside.service;

import java.util.List;

import com.serverside.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serverside.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User dengan id " + id + " tidak ditemukan!!"));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

//    public User create(User user) {
//        User existingUser = userRepository.findByName(user.getUsername()).orElse(null);
//        if (existingUser == null && user.getId() == null) {
//            return userRepository.save(user);
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama user sudah ada!");
//        }
//    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Menggunakan BeanUtils untuk menyalin properti dari updatedUser ke existingUser
            BeanUtils.copyProperties(user, existingUser, "id", "createdAt");
            return userRepository.save(existingUser);
        }
        return null;
    }

    public User delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

}

