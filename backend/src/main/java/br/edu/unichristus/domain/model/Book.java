//Model representa uma entidade do sistema, ou seja, um objeto do
//"mundo real" que queremos armazenar no banco. No caso, LIVRO.
//Ele mapeia os atributos do objeto para colunas de uma
//tabela no banco.

package br.edu.unichristus.domain.model;

import jakarta.persistence.*;

@Entity  // MARCA ESSA CLASSE COMO UMA ENTIDADE DO JPA (vai virar uma tabela no banco de dados)
@Table(name = "tb_book")  // NOME DA TABELA NO BANCO
public class Book {

    @Id  // Identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera IDs automaticamente (auto-incremento)
    private Long id;

    private String title;     // Título do livro
    private String author;    // Autor do livro

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;  // Editora do livro

    private Integer year;     // Ano de publicação
    private String edition;   // Edição do livro

    // Getters e setters — permitem acessar/modificar os dados de fora da classe
    //fn + alt + insert

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
