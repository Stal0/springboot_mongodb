package com.stalixo.springbootmongo.services;

import com.stalixo.springbootmongo.domain.Post;
import com.stalixo.springbootmongo.repository.PostRepository;
import com.stalixo.springbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> user = repo.findById(id);
        user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return user.get();
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

}
