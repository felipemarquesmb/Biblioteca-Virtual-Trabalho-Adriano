//Model representa uma entidade do sistema, ou seja, um objeto do
//"mundo real" que queremos armazenar no banco. No caso, FAVORITO.
//Ele mapeia os atributos do objeto para colunas de uma
//tabela no banco.


package br.edu.unichristus.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity  // MARCA ESSA CLASSE COMO UMA ENTIDADE DO JPA (vai virar uma tabela no banco de dados)
@Table(name = "tb_favorite")  // NOME DA TABELA NO BANCO
public class Favorite {

    @Id  // Identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera IDs automaticamente (auto-incremento)
    private Long id;

    // Um usuário pode favoritar vários livros
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Um livro pode estar nos favoritos de vários usuários
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Getters e setters — permitem acessar/modificar os dados de fora da classe
    //fn + alt + insert


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
