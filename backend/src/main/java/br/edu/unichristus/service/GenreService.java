package br.edu.unichristus.service;


import br.edu.unichristus.domain.model.Genre;
import br.edu.unichristus.exception.CommonsException;  // Importa exceção personalizada da aplicação
import br.edu.unichristus.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importa status HTTP (para usar em respostas de erro)
import org.springframework.stereotype.Service; // Importa anotação de componente de serviço

import java.util.List;

@Service  // Marca como um serviço do Spring (classe de lógica de negócio)
public class GenreService {

    @Autowired  // Injeta automaticamente o repositório
    private GenreRepository repository;

    public Genre save(Genre genre){
        // Salva ou atualiza um usuário no banco
        var savedGenre = repository.save(genre); //
        return savedGenre; //
    }

    public List<Genre> findAll(){
        // Retorna todos os usuários
        var listGenre = repository.findAll();
        return listGenre;
    }

    public Genre findById(Long id){
        // Busca um usuáro por ID. Se não encontrar, lança exceção personalizada.
        var userEntity = repository.findById(id);
        if(userEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.genre.findbyid.notfound",
                    "Gênero não encontrado!");
        }

        return repository.findById(id).get();
    }

    public void delete(Long id){
        // Deleta um usuário pelo ID
        repository.deleteById(id);
    }
}



