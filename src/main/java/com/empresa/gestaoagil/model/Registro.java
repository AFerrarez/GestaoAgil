package com.empresa.gestaoagil.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Registro  {

    private final String id;
    private final BigDecimal valor;
    private final int quantidade;
    private final LocalDateTime dataCriacao;

    /**
     * Construtor que inicializa os atributos do Registro.
     *
     * @param id           Identificador único, não nulo.
     * @param valor        Valor monetário, não nulo e não negativo.
     * @param quantidade   Quantidade, não pode ser negativa.
     * @param dataCriacao  Data e hora de criação, não nula.
     */
    public Registro(String id, BigDecimal valor, int quantidade, LocalDateTime dataCriacao) {
        this.id = Objects.requireNonNull(id, "O identificador não pode ser nulo");

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo ou negativo");
        }
        this.valor = valor;

        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;

        this.dataCriacao = Objects.requireNonNull(dataCriacao, "A data de criação não pode ser nula");
    }

    // Getters
    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
