//Model representa uma entidade do sistema, ou seja, um objeto do
//"mundo real" que queremos armazenar no banco. No caso, GÊNERO.
//Ele mapeia os atributos do objeto para colunas de uma
//tabela no banco.

package br.edu.unichristus.domain.model;

import jakarta.persistence.*;

@Entity   // MARCA ESSA CLASSE COMO UMA ENTIDADE DO JPA (vai virar uma tabela no banco de dados)
@Table(name= "tb_genre") // NOME DA TABELA NO BANCO
public class Genre{

    @Id   // Identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera IDs automaticamente (auto-incremento)
    private Long id;

    private String type;  //Tipo do gênero(romance, fantasia, terror...)
    private String description; //Breve descrição do gênero
    private String targetAudience; //Público-alvo
    private String language; //Idioma predominante



    // Getters e setters — permitem acessar/modificar os dados de fora da classe
    //fn + alt + insert


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
