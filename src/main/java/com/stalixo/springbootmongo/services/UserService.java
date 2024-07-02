package com.stalixo.springbootmongo.services;

import com.stalixo.springbootmongo.domain.User;
import com.stalixo.springbootmongo.dto.UserDTO;
import com.stalixo.springbootmongo.repository.UserRepository;
import com.stalixo.springbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return user.get();
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

}
