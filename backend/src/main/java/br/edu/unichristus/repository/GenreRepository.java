//O Repository é responsável por acessar o banco de dados. Ele lida com as
// operações básicas: salvar, buscar, deletar, atualizar.
//O Spring Data JPA facilita isso com a interface JpaRepository.


package br.edu.unichristus.repository;

import br.edu.unichristus.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;   //ACHO QUE NÃO ESTÁ SENDO USADO

public interface GenreRepository extends JpaRepository<Genre, Long> {
    // JpaRepository fornece todos os métodos CRUD prontos: save, findById, findAll, deleteById, etc.

}
