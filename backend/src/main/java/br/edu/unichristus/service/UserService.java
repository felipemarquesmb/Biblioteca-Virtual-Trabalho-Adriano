package br.edu.unichristus.service;

import br.edu.unichristus.domain.dto.UserDTO;
import br.edu.unichristus.domain.dto.UserLowDTO;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.repository.UserRepository;
import br.edu.unichristus.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserLowDTO save(UserDTO user){
        var userEntity = MapperUtil.parseObject(user, User.class);
        var savedUser = repository.save(userEntity);
        return MapperUtil.parseObject(savedUser, UserLowDTO.class);
    }

    public List<UserLowDTO> findAll(){
        var listUsers = repository.findAll();
        return MapperUtil.parseListObjects(listUsers, UserLowDTO.class);
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
