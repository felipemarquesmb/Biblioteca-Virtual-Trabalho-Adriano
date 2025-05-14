package br.edu.unichristus.service;


import br.edu.unichristus.domain.model.Publisher;
import br.edu.unichristus.exception.CommonsException;  // Importa exceção personalizada da aplicação
import br.edu.unichristus.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importa status HTTP (para usar em respostas de erro)
import org.springframework.stereotype.Service; // Importa anotação de componente de serviço

import java.util.List;

@Service  // Marca como um serviço do Spring (classe de lógica de negócio)
public class PublisherService {

    @Autowired // Injeta automaticamente o repositório
    private PublisherRepository repository;

    public Publisher save(Publisher publisher){
        // Salva ou atualiza uma editora no banco
        var savedPublisher = repository.save(publisher); //
        return savedPublisher; //
    }

    public List<Publisher> findAll(){
        // Retorna todos os usuários
        var listPublisher = repository.findAll();
        return listPublisher;
    }

    public Publisher findById(Long id){
        // Busca uma editora por ID. Se não encontrar, lança exceção personalizada.
        var publisherEntity = repository.findById(id);
        if(publisherEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.publisher.findbyid.notfound",
                    "Editora não encontrada!");
        }

        return repository.findById(id).get();
    }

    public void delete(Long id){
        // Deleta um usuário pelo ID

        repository.deleteById(id);
    }

}
