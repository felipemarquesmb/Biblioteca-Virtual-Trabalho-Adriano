//Model representa uma entidade do sistema, ou seja, um objeto do
//"mundo real" que queremos armazenar no banco. No caso, USUÁRIO.
//Ele mapeia os atributos do objeto para colunas de uma
//tabela no banco.



//USAR USER COMO BASE PARA OUTRAS ENTIDADES


package br.edu.unichristus.domain.model;

import jakarta.persistence.*;

import java.util.Objects;   //ACHO QUE ISSO NÃO TÁ SENDO USADO

@Entity     // MARCA ESSA CLASSE COMO UMA ENTIDADE DO JPA (vai virar uma tabela no banco de dados)
@Table(name = "tb_user")  // NOME DA TABELA NO BANCO
public class User {

    @Id   // Identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera IDs automaticamente (auto-incremento)
    private Long id;


    private String name;  //Nome do usuário
    private String email; //Email do usuário

    private String login; //Login do usuário
    private String password;  //Senha do usuário


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
