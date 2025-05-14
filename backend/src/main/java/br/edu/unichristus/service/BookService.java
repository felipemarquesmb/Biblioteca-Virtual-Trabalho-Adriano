package br.edu.unichristus.service;



import br.edu.unichristus.domain.model.Book;
import br.edu.unichristus.exception.CommonsException;  // Importa exceção personalizada da aplicação
import br.edu.unichristus.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importa status HTTP (para usar em respostas de erro)
import org.springframework.stereotype.Service; // Importa anotação de componente de serviço

import java.util.List;

@Service  // Marca como um serviço do Spring (classe de lógica de negócio)
public class BookService {

    @Autowired  // Injeta automaticamente o repositório
    private BookRepository repository;

    public Book save(Book book){
        // Salva ou atualiza um livro no banco
        var savedBook = repository.findAll();
        return repository.save(book);   //return savedBook; ??????????
    }
    public List<Book> findAll(){
        // Retorna todos os livros
        var listBooks = repository.findAll();
        return listBooks;
    }

    public Book findById(Long id){
        // Busca um livro por ID. Se não encontrar, lança exceção personalizada.
        var bookEntity = repository.findById(id);
        if (bookEntity.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.book.findbyid.notfound",
                    "Livro não encontrado!");
        }
        return repository.findById(id).get();
    }

    public void delete(Long id){
        // Deleta um livro pelo ID
        repository.deleteById(id);
    }
}
