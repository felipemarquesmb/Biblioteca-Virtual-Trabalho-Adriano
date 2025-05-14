//Model representa uma entidade do sistema, ou seja, um objeto do
//"mundo real" que queremos armazenar no banco. No caso, EDITORA.
//Ele mapeia os atributos do objeto para colunas de uma
//tabela no banco.

package br.edu.unichristus.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;  // USO ESSE MESMO??????????

@Entity  // MARCA ESSA CLASSE COMO UMA ENTIDADE DO JPA (vai virar uma tabela no banco de dados)
@Table(name = "tb_publisher")  // NOME DA TABELA NO BANCO
public class Publisher {

    @Id // Identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera IDs automaticamente (auto-incremento)
    private Long id;

    private String name; // Nome da editora
    private String country; // País de origem
    private String website; // Site oficial
    private String email; // Email de contato

    @OneToMany(mappedBy = "publisher") // Uma editora pode publicar vários livros
    @JsonIgnore
    private List<Book> books;

    // Getters e setters — permitem acessar/modificar os dados de fora da classe
    //fn + alt + insert

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }
}
