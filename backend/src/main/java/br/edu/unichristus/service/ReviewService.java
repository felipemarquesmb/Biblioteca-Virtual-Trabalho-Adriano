package br.edu.unichristus.service;

import br.edu.unichristus.domain.model.Review;
import br.edu.unichristus.exception.CommonsException;  // Importa exceção personalizada da aplicação
import br.edu.unichristus.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importa status HTTP (para usar em respostas de erro)
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marca como um serviço do Spring (classe de lógica de negócio)
public class ReviewService {

    @Autowired  // Injeta automaticamente o repositório
    private ReviewRepository repository;

    public Review save(Review review){
        // Salva ou atualiza uma avaliação no banco
        var savedReview = repository.save(review); //
        return savedReview; //
    }

    public List<Review> findAll(){
        // Retorna todas as avaliações
        var listReview = repository.findAll();
        return listReview;
    }

    public Review findById(Long id){
        // Busca uma avaliação por ID. Se não encontrar, lança exceção personalizada.
        var reviewEntity = repository.findById(id);
        if(reviewEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.review.findbyid.notfound",
                    "Usuário não encontrado!");
        }

        return repository.findById(id).get();
    }

    public void delete(Long id){
        // Deleta um usuário pelo ID

        repository.deleteById(id);
    }
}
