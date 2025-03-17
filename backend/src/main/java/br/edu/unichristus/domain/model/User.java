package br.edu.unichristus.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;
    private String email;

    @Column(unique = true)
    private String login;
    private String password;

}
