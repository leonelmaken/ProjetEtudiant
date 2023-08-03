package com.mono.pjdepartement.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.entity.repository.UserRepository;
import com.mono.pjdepartement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "l'user a été supprimé";
    }

    @Override
    public User getUser(Long id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<User> getByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    @Override
    public List<User> getByNumTel(Long numTel) {
        return userRepository.findByNumTel(numTel);
    }

    @Override
    public List<User> getByMail(String mail) {
        return userRepository.findByMail(mail);
    }

}