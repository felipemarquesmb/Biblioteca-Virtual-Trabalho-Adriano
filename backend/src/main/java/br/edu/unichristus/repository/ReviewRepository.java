//O Repository é responsável por acessar o banco de dados. Ele lida com as
// operações básicas: salvar, buscar, deletar, atualizar.
//O Spring Data JPA facilita isso com a interface JpaRepository.


package br.edu.unichristus.repository;

import br.edu.unichristus.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // JpaRepository fornece todos os métodos CRUD prontos: save, findById, findAll, deleteById, etc.
}
