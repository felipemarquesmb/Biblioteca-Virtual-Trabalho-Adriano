package br.edu.unichristus.service;

import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user){
        var savedUser = repository.save(user);
        return savedUser;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
