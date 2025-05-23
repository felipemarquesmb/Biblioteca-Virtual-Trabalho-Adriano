package br.edu.unichristus.service;


import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.exception.CommonsException;  // Importa exceção personalizada da aplicação
import br.edu.unichristus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importa status HTTP (para usar em respostas de erro)
import org.springframework.stereotype.Service; // Importa anotação de componente de serviço

import java.util.List;

@Service  // Marca como um serviço do Spring (classe de lógica de negócio)
public class UserService {

    @Autowired  // Injeta automaticamente o repositório
    private UserRepository repository;

    public User save(User user){
        // Salva ou atualiza um usuário no banco
        var savedUser = repository.save(user); //
        return savedUser; //
    }

    public List<User> findAll(){
        // Retorna todos os usuários
        var listUsers = repository.findAll();
        return listUsers;
    }

    public User findById(Long id){
        // Busca um usuáro por ID. Se não encontrar, lança exceção personalizada.
        var userEntity = repository.findById(id);
        if(userEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.user.findbyid.notfound",
                    "Usuário não encontrado!");
        }

        return repository.findById(id).get();
    }

    public void delete(Long id){
        // Deleta um usuário pelo ID

        repository.deleteById(id);
    }
}



