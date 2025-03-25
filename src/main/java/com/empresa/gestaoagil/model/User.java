package com.empresa.gestaoagil.model;

import java.util.Objects;

public final class User {
    private final String nome;
    private final String email;
    private final String cargo;

    /**
     * Construtor que inicializa os atributos do usuário.
     *
     * @param nome  Nome do usuário, não nulo.
     * @param email E-mail do usuário, não nulo.
     * @param cargo Cargo do usuário, não nulo.
     */
    public User(String nome, String email, String cargo) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.email = Objects.requireNonNull(email, "Email não pode ser nulo");
        this.cargo = Objects.requireNonNull(cargo, "Cargo não pode ser nulo");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    /**
     * Retorna uma nova instância de User com o e-mail atualizado.
     *
     * @param novoEmail Novo e-mail do usuário.
     * @return nova instância de User com o e-mail alterado.
     */
    public User atualizarEmail(String novoEmail) {
        return new User(this.nome, novoEmail, this.cargo);
    }

    /**
     * Retorna uma nova instância de User com o cargo atualizado.
     *
     * @param novoCargo Novo cargo do usuário.
     * @return nova instância de User com o cargo alterado.
     */
    public User definirCargo(String novoCargo) {
        return new User(this.nome, this.email, novoCargo);
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}